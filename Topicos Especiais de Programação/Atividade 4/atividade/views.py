from django.shortcuts import render

# Create your views here.
from django.views import View
from rest_framework.authtoken.models import Token
from rest_framework.authtoken.views import ObtainAuthToken
from rest_framework.response import Response
from rest_framework import generics, status, permissions
from rest_framework.reverse import reverse
from rest_framework.throttling import ScopedRateThrottle
from rest_framework.views import APIView

from atividade.models import Post, Comment
from atividade.permissions import IsPostOwnerOrReadOnly
from atividade.serializer import PostSerializer, CommentSerializer, UserSerializer, UserCountPostCommentSerializer
from atividade.models import Usuario, Address
from atividade.serializer import UserPostSerializer, AdreesSerializer


class ApiRoot(generics.GenericAPIView):
    name = 'api-root'

    def get(self, request, *args, **kwargs):
        return Response({
            'users': reverse(UserList.name, request=request),
            'posts': reverse(PostList.name, request=request),
            'comments': reverse(CommentList.name, request=request),
            '': '',
            # '': '',
            'address': reverse(AdreesList.name, request=request),
            'profile-posts': reverse(ProfilePostsList.name, request=request),
            'profile': reverse(UserPostList.name, request=request),
            'user-detail': reverse(UserCountPostComment.name, request=request),
        })


class CustomAuthToken(ObtainAuthToken):
    throttle_scope = 'api-token'
    throttle_classes = (ScopedRateThrottle,)

    def post(self, request, *args):
        serializer = self.serializer_class(data=request.data, context={'request': request})
        print(serializer)
        serializer.is_valid(raise_exception=True)
        usuario = serializer.validated_data['user']
        token, created = Token.objects.get_or_create(user=usuario)
        return Response({
            'token': token.key,
            'user_id': usuario.pk,
            'email': usuario.email
        })


class PostList(generics.ListCreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostSerializer
    name = 'post-list'

    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly,
    )
    throttle_classes = (ScopedRateThrottle,)


class PostDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Post.objects.all()
    serializer_class = PostSerializer
    name = 'post-detail'

    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly,
    )
    throttle_classes = (ScopedRateThrottle,)


class CommentList(generics.ListCreateAPIView):
    queryset = Comment.objects.all()
    serializer_class = CommentSerializer
    name = 'comment-list'

    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly,
    )
    throttle_classes = (ScopedRateThrottle,)


class CommentDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Comment.objects.all()
    serializer_class = CommentSerializer
    name = 'comment-detail'

    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly,
    )
    throttle_classes = (ScopedRateThrottle,)


class UserList(generics.ListAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserSerializer
    name = 'user-list'

    permission_classes = (
        permissions.IsAuthenticated,
        # IsOwnerOrReadOnly
    )
    throttle_classes = (ScopedRateThrottle,)


class UserDetail(generics.RetrieveAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserSerializer
    name = 'user-detail'

    permission_classes = (
        permissions.IsAuthenticated,
        # IsOwnerOrReadOnly
    )
    throttle_classes = (ScopedRateThrottle,)


class ProfilePostsList(generics.ListCreateAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserPostSerializer
    name = 'profileposts-list'
    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly
    )

    def perform_create(self, serializer):
        serializer.save(owner=self.request.user)


class ProfilePostsDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserPostSerializer
    name = 'profileposts-detail'
    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly
    )


class AdreesList(generics.ListCreateAPIView):
    queryset = Address.objects.all()
    serializer_class = AdreesSerializer
    name = 'address-list'


class AdreesDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Address.objects.all()
    serializer_class = AdreesSerializer
    name = 'address-detail'


class UserPostList(generics.ListCreateAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserPostSerializer
    name = 'userpost-list'
    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly
    )


class UserPostDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserPostSerializer
    name = 'userpost-detail'
    permission_classes = (
        permissions.IsAuthenticatedOrReadOnly,
        IsPostOwnerOrReadOnly
    )


class UserCountPostComment(generics.ListCreateAPIView):
    queryset = Usuario.objects.all()
    serializer_class = UserCountPostCommentSerializer
    name = 'usercountpostcomment-detail'


class PostsOfUserList(APIView):

    # serializer_class = PostSerializer
    # name = 'postsofuser-list'

    # def get_queryset(self):
    #     queryset = Post.objects.filter(user_id=self.kwargs['pk_user'])
    #     return queryset

    def get(self, request, pk_user, format=None):
        posts = Post.objects.filter(usuario_id=pk_user)
        post_serializer = PostSerializer(posts, many=True, context={'request': request})
        return Response(post_serializer.data)


class PostsOfUserDetail(APIView):
    def get(self, request, pk_user, pk_post):
        posts = Post.objects.get(usuario_id=pk_user, id=pk_post)
        post_serializer = PostSerializer(posts, context={'request': request})

        return Response(post_serializer.data)

    def post(self, request):
        post_serializer = PostSerializer(data=request.data)
        if post_serializer.is_valid():
            post_serializer.save()
            return Response(post_serializer.data, status=status.HTTP_201_CREATED)
        return Response(post_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk_user, pk_post):
        posts = Post.objects.get(usuario_id=pk_user, id=pk_post)
        comments = Comment.objects.filter(post_id=posts.id)
        for i in comments:
            i.delete()
        posts.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class CommentsOfPostList(APIView):

    def get(self, request, pk_post, pk_user):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        comments = Comment.objects.filter(post_id=post_id)
        serializer = CommentSerializer(comments, many=True, context={'request': request})
        return Response(serializer.data)


class CommentOfPostDetail(APIView):

    def get(self, request, pk_post, pk_user, pk_comment):
        post_id = Post.objects.get(id=pk_post)
        comment = Comment.objects.filter(post_id=post_id, id=pk_comment)
        comment_serializer = CommentSerializer(comment, many=True, context={'request': request})
        return Response(comment_serializer.data)

    def post(self, request):
        comment_serializer = CommentSerializer(data=request.data)
        if comment_serializer.is_valid():
            # comment_serializer.post(post=Post.objects.get(id=pk_post))
            # comment_serializer.post.use
            comment_serializer.save()
            return Response(comment_serializer.data, status=status.HTTP_201_CREATED)
        return Response(comment_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk_user, pk_post, pk_comment):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        comment = Comment.objects.filter(post_id=post_id, id=pk_comment)
        comment.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
