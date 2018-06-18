from django.contrib.auth.models import User

from atividade.models import *

file = "db.json"

json = eval(open(file, "r").read())

users = json['users']
posts = json['posts']
comments = json['comments']
# addresses = json['users']['address']

for user in users:

    Usuario.objects.create_user(
        name=user['name'],
        email=user['email'],
        username=user['username'].lower(),
        password='senha12345',
        is_superuser=True,
    ).save()

    user_id = Usuario.objects.get(id=user['id'])

    Address(
        usuario=user_id,
        street=user['address']['street'],
        suite=user['address']['suite'],
        city=user['address']['city'],
        zipcode=user['address']['zipcode'],
    ).save()

for post in posts:
    Post.objects.create(
        owner=Usuario.objects.get(id=post['userId']),
        # usuario=Usuario.objects.get(id=post['userId']),
        title=post['title'].replace('\n', ''),
        body=post['body'].replace('\n', '')
    ).save()

for comment in comments:
    Comment.objects.create(
        post=Post.objects.get(id=comment['postId']),
        name=comment['name'].replace('\n', ''),
        email=comment['email'].replace('\n', ''),
        body=comment['body'].replace('\n', ''),
    ).save()
