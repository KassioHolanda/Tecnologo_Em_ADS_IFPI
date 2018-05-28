from rest_framework import serializers

from atividade.models import Post, Comment, User, Address


class CommentSerializer(serializers.HyperlinkedModelSerializer):
    post = serializers.SlugRelatedField(queryset=Post.objects.all(), slug_field='title')

    class Meta:
        model = Comment
        fields = ('pk', 'name', 'email', 'body', 'post', 'url')


class PostSerializer(serializers.HyperlinkedModelSerializer):
    comments = CommentSerializer(many=True, read_only=True)
    user = serializers.SlugRelatedField(queryset=User.objects.all(), slug_field='name')

    class Meta:
        model = Post
        fields = ('pk', 'user', 'title', 'body', 'count_comments', 'comments')


class AdreesSerializer(serializers.HyperlinkedModelSerializer):
    user = serializers.SlugRelatedField(queryset=User.objects.all(), slug_field='name')

    class Meta:
        model = Address
        fields = ('pk', 'street', 'suite', 'city', 'zipcode', 'user')


class UserPostSerializer(serializers.HyperlinkedModelSerializer):
    address = AdreesSerializer(many=True, read_only=True)
    posts = PostSerializer(many=True, read_only=True)

    class Meta:
        model = User
        fields = ('pk', 'name', 'email', 'address', 'posts')


class UserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = User
        fields = ('name', 'email')

class UserCountPostComment(serializers.HyperlinkedModelSerializer):
    pass