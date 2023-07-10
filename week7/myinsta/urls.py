from django.contrib import admin
from django.urls import path
from posts.views import lotto

urlpatterns = [
    path('admin/', admin.site.urls),
    path('lotto/', lotto, name='lotto'),
]