from django.contrib import admin
from django.urls import path, include
from rest_framework import routers
from posts.views import *

#router=routers.DefaultRouter()
#router.register('posts', PostModelViewSet)

urlpatterns = [
    #path('', include(router.urls)),
    path('admin/', admin.site.urls),

    #게시글 목록 + 생성
    path('posts/', PostListCreateView.as_view(), name = 'post-list-create'),
    
    #게시글 상세
    path('posts/<int:pk>/', PostRetrieveUpdateView.as_view(), name='post-detail'),
]