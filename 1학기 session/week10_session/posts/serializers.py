from rest_framework.serializers import ModelSerializer
from .models import Post, Comment

class PostModelSerializer(ModelSerializer):
    class Meta:
        model=Post
        fields='__all__'
        #fields=['id', 'writer', 'content']

class PostListSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = [
            'id',
            'image',
            'content',
            'created_at',
            'view_count',
            'writer',
        ]

class PostCreateSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = [
            'image',
            'content',
        ]
        depth = 1 # User 모델을 다 불러와준다

class PostRetrieveSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        depth = 1

class CommentListModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'