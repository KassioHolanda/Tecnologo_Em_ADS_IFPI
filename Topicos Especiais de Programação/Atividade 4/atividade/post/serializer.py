from rest_framework import serializers

from post.models import Post, Comment, User, Adrees


class PostSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Post
        fields = ('title', 'body', 'user')


class CommentSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Comment
        fields = ('name', 'email', 'body', 'post')


class UserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = User
        fields = ('name', 'email', 'adrees')


class AdreesSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Adrees
        fields = ('street', 'suite', 'city', 'zipcode')
