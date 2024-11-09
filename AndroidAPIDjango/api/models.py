from django.db import models

# Create your models here.
class Post(models.Model):
    user = models.CharField(max_length=150)
    date = models.CharField(max_length=20)
    text = models.TextField(max_length=400)
    commentNum = models.IntegerField()
    repostNum = models.IntegerField()
    likesNum = models.IntegerField()