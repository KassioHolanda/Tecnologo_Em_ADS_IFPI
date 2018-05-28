from django.shortcuts import render

# Create your views here.
from django.views import View
from rest_framework.response import Response
from rest_framework import generics, status
from rest_framework.reverse import reverse
from rest_framework.views import APIView

from atividade.models import Post, Comment
from atividade.serializer import PostSerializer, CommentSerializer, UserSerializer, UserCountPostCommentSerializer
from atividade.models import User, Address
from atividade.serializer import UserPostSerializer, AdreesSerializer


class ApiRoot(generics.GenericAPIView):
    name = 'api-root'

    def get(self, request, *args, **kwargs):
        return Response({
            'users': reverse(UserList.name, request=request),
            'posts': reverse(PostList.name, request=request),
            'comments': reverse(CommentList.name, request=request),
            'user-posts': reverse(UserPostList.name, request=request),
            'user-detail': reverse(UserCountPostComment.name, request=request),
        })


class PostList(generics.ListCreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostSerializer
    name = 'atividade-list'


class PostDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Post.objects.all()
    serializer_class = PostSerializer
    name = 'atividade-list'


class CommentList(generics.ListCreateAPIView):
    queryset = Comment.objects.all()
    serializer_class = CommentSerializer
    name = 'comment-list'


class CommentDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Comment.objects.all()
    serializer_class = CommentSerializer
    name = 'comment-detail'


class UserList(generics.ListCreateAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    name = 'user-list'


class UserDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    name = 'user-detail'


class AdreesList(generics.ListCreateAPIView):
    queryset = Address.objects.all()
    serializer_class = AdreesSerializer
    name = 'address-list'


class AdreesDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Address.objects.all()
    serializer_class = AdreesSerializer
    name = 'address-detail'


class UserPostList(generics.ListCreateAPIView):
    queryset = User.objects.all()
    serializer_class = UserPostSerializer
    name = 'userpost-list'


class UserPostDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = User.objects.all()
    serializer_class = UserPostSerializer
    name = 'userpost-detail'


class UserCountPostComment(generics.ListCreateAPIView):
    queryset = User.objects.all()
    serializer_class = UserCountPostCommentSerializer
    name = 'usercountpostcomment-detail'


class PostsOfUserList(APIView):
    # serializer_class = PostSerializer
    # name = 'postsofuser-list'

    # def get_queryset(self):
    #     queryset = Post.objects.filter(user_id=self.kwargs['pk_user'])
    #     return queryset

    def get_object(self, pk_user):
        return Post.objects.filter(user_id=pk_user)

    def get(self, request, pk_user, format=None):
        posts = Post.objects.filter(user_id=pk_user)
        post_serializer = PostSerializer(posts, many=True, context={'request': request})
        return Response(post_serializer.data)


class PostsOfUserDetail(APIView):

    def get_object(self, pk_user, pk_post):
        return Post.objects.get(user_id=pk_user, id=pk_post)

    def get(self, request, pk_user, pk_post):
        posts = Post.objects.get(user_id=pk_user, id=pk_post)
        post_serializer = PostSerializer(posts, context={'request': request})
        return Response(post_serializer.data)


    def post(self, request):
        post_serializer = PostSerializer(data=request.data)
        if post_serializer.is_valid():
            post_serializer.save()
            return Response(post_serializer.data, status=status.HTTP_201_CREATED)
        return Response(post_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk_user, pk_post):
        posts = Post.objects.get(user_id=pk_user, id=pk_post)
        comments = Comment.objects.filter(post_id=posts.id)
        for i in comments:
            i.delete()
        posts.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


class CommentsOfPostList(APIView):
    def get_object(self, pk_post, pk_user):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        return Comment.objects.filter(post_id=post_id)

    def get(self, request, pk_post, pk_user):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        comments = Comment.objects.filter(post_id=post_id)
        serializer = CommentSerializer(comments, many=True, context={'request': request})
        return Response(serializer.data)


class CommentOfPostDetail(APIView):
    def get_object(self, pk_post, pk_user, pk_comment):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        return Comment.objects.filter(post_id=post_id, id=pk_comment)

    def get(self, request, pk_post, pk_user, pk_comment):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        comment = Comment.objects.filter(post_id=post_id, id=pk_comment)
        comment_serializer = CommentSerializer(comment, many=True, context={'request': request})
        return Response(comment_serializer.data)

    def post(self, request):
        comment_serializer = CommentSerializer(data=request.data)
        if comment_serializer.is_valid():
            comment_serializer.save()
            return Response(comment_serializer.data, status=status.HTTP_201_CREATED)
        return Response(comment_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, pk_user, pk_post, pk_comment):
        post_id = Post.objects.get(user_id=pk_user, id=pk_post)
        comment = Comment.objects.filter(post_id=post_id, id=pk_comment)
        comment.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
