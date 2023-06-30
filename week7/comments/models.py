from django.db import models

# Create your models here.

class Comment (models.Model) :

    image = models.ImageField(verbose_name='프로필이미지')
    contentn = models.TextField('내용')
    created_at = models.DateTimeField('댓글 작성일')