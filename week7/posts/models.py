from django.db import models

# Create your models here.

class Post(models.Model) :
    image = models.ImageField(verbose_name='이미지')
    content = models.TextField('내용')
    created_at = models.DateTimeField('작성일')
    view_count = models.ImageField('조회수')

class Game(models.Model):
    global game_num
    game_num = models.IntegerField(verbose_name='게임 수')