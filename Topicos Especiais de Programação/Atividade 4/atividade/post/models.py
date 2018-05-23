from django.db import models


# Create your models here.

class Adrees(models.Model):
    street = models.CharField(max_length=255)
    suite = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    zipcode = models.CharField(max_length=255)


class User(models.Model):
    name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    adrees = models.ForeignKey(Adrees, on_delete=models.CASCADE)

class Post(models.Model):
    title = models.CharField(max_length=255)
    body = models.CharField(max_length=255)
    user = models.ForeignKey(User, on_delete=models.CASCADE)


class Comment(models.Model):
    name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    body = models.CharField(max_length=255)
    post = models.ForeignKey(Post, on_delete=models.CASCADE)


