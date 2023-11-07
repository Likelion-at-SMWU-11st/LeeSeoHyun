from django.contrib import admin
from django.urls import path, include, re_path
from rest_framework import routers, permissions
from posts.views import *
from django.conf import settings
from django.conf.urls.static import static
from accounts_token.views import login_view
from drf_yasg.views import get_schema_view
from drf_yasg import openapi


schema_view = get_schema_view(
    openapi.Info(
        title="Snippets API",
        default_version="v1",
        description="Test desription",
        terms_of_service="https://www.google.com/policies/terms/",
        contact=openapi.Contact(email="contact@snippets.local"),
        license=openapi.License(name="BSD License"),
    ),
    public=True,
    permission_classes=(permissions.AllowAny,),
)

router=routers.DefaultRouter()
router.register('posts', PostModelViewSet)

urlpatterns = [
    path('', include(router.urls)),
    path('admin/', admin.site.urls),

    #게시글 목록 + 생성
    #path('posts/', PostListCreateView.as_view(), name = 'post-list-create'),
    
    #게시글 상세
    #path('posts/<int:pk>/', PostRetrieveUpdateView.as_view(), name='post-detail'),

    # 토큰 인증 로그인 구현
    path('login/', login_view),

    # swagger
    path('swagger<format>/', schema_view.without_ui(cache_timeout=0), name='schema=json'),
    path('swagger/', schema_view.with_ui('swagger', cache_timeout=0), name='schema-swagger-ui'),
    path('redoc/', schema_view.with_ui('redoc', cache_timeout=0), name='schema-redoc'),
]