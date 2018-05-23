from django.shortcuts import render

# Create your views here.
from rest_framework import generics

from post.models import Post, Comment
from post.serializer import PostSerializer, CommentSerializer
from post.models import User, Adrees
from post.serializer import UserSerializer, AdreesSerializer


class PostList(generics.ListCreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostSerializer
    name = 'post-list'


class PostDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Post.objects.all()
    serializer_class = PostSerializer
    name = 'post-list'


class CommentList(generics.ListCreateAPIView):
    queryset = Comment.objects.all()
    serializer_class = CommentSerializer
    name = 'comment-list'


class UserList(generics.ListCreateAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    name = 'user-list'


class UserDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    name = 'user-detail'


class AdreesList(generics.ListCreateAPIView):
    queryset = Adrees.objects.all()
    serializer_class = AdreesSerializer
    name = 'adrees-list'


class AdreesDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Adrees.objects.all()
    serializer_class = AdreesSerializer
    name = 'adrees-detail'
