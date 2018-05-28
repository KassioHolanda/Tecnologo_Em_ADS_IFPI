from atividade.models import *

file = "db.json"

json = eval(open(file, "r").read())

users = json['users']
posts = json['posts']
comments = json['comments']
# addresses = json['users']['address']

for user in users:
    User.objects.create(
        name=user['name'],
        email=user['email'],
    ).save()

    user_id = User.objects.get(id=user['id'])

    Address(
        user=user_id,
        street=user['address']['street'],
        suite=user['address']['suite'],
        city=user['address']['city'],
        zipcode=user['address']['zipcode'],
    ).save()

for post in posts:
    Post.objects.create(
        user=User.objects.get(id=post['userId']),
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
