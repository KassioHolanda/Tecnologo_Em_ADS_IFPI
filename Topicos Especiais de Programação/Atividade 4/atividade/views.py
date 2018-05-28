from django.shortcuts import render

# Create your views here.
from requests import Response
from rest_framework import generics
from rest_framework.reverse import reverse

from atividade.models import Post, Comment
from atividade.serializer import PostSerializer, CommentSerializer, UserPostSerializer, UserSerializer
from atividade.models import User, Address
from atividade.serializer import UserPostSerializer, AdreesSerializer


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


class ApiRoot(generics.GenericAPIView):
    name = 'api-root'

    def get(self, request, *args, **kwargs):
        return Response({
            'users': reverse(UserList.name, request=request),
            'posts': reverse(PostList.name, request=request)
        })
