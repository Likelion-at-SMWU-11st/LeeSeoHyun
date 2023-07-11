from django.contrib import admin
from django.urls import path
from posts.views import lotto
from posts.views import result
from posts import views
from posts.views import lotto_index


urlpatterns = [
    path('admin/', admin.site.urls),
    path('lotto/', lotto, name='lotto'),
    path('lotto/result/', result, name='result'),
    path('lotto/result/', lotto_index, name='lotto_index'),
]