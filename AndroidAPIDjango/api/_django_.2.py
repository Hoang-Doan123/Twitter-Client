from django.db import models

class Post(models.Model):
    commentNum = models.IntegerField()
    repostNum = models.IntegerField()
    likesNum = models.IntegerField()