from rest_framework import serializers

from atividade.models import Post, Comment, Usuario, Address


class CommentSerializer(serializers.HyperlinkedModelSerializer):
    post = serializers.SlugRelatedField(queryset=Post.objects.all(), slug_field='title')

    class Meta:
        model = Comment
        fields = ('pk', 'name', 'email', 'body', 'post', 'url')


class PostSerializer(serializers.HyperlinkedModelSerializer):
    owner = serializers.ReadOnlyField(source='owner.username')
    # comments = CommentSerializer(many=True, read_only=True)

    # usuario = serializers.SlugRelatedField(queryset=Usuario.objects.all(), slug_field='username')

    class Meta:
        model = Post
        fields = ('pk', 'owner', 'title', 'body', 'count_comments')


class AdreesSerializer(serializers.HyperlinkedModelSerializer):
    usuario = serializers.SlugRelatedField(queryset=Usuario.objects.all(), slug_field='name')

    class Meta:
        model = Address
        fields = ('pk', 'street', 'suite', 'city', 'zipcode', 'usuario')


class UserPostSerializer(serializers.HyperlinkedModelSerializer):
    address = AdreesSerializer(many=True, read_only=True)
    posts = PostSerializer(many=True, read_only=True)

    class Meta:
        model = Usuario
        fields = ('pk', 'name', 'email', 'address', 'posts')


class UserSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Usuario
        fields = ('name', 'email')


class UserCountPostCommentSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Usuario
        fields = ('pk', 'name', 'total_posts', 'total_comments')
