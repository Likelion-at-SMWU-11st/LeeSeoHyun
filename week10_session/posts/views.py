from django.shortcuts import render, redirect, get_object_or_404
from django.http import HttpResponse, JsonResponse
from rest_framework.viewsets import ModelViewSet
from .serializers import PostModelSerializer, PostListSerializer, PostRetrieveSerializer
from django.views.generic import ListView
from .models import Post
from rest_framework.decorators import api_view
from rest_framework.response import Response
from .forms import PostBasedForm, PostCreatedForm, PostDetailForm, PostUpdateForm
from rest_framework import generics, status

#게시글 목록 + 생성
class PostListCreateView(generics.ListAPIView, generics.CreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

    def post(self, request, *args, **kwargs):
        return self.create(request, *args, **kwargs)

    def create(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        #self.perform_create(serializer)

        #작성자
        if request.user.is_authenticated: #허용된 인증자일 경우 생성자까지 포함하여 저장
            serializer.save(writer=request.user)
        else: #로그인이 되어있지 않으면 생성자 없이 그냥 저장
            serializer.save()

        headers = self.get_success_headers(serializer.data)
        return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)

class PostModelViewSet(ModelViewSet):
    queryset=Post.objects.all()
    serializer_class=PostListSerializer
#게시글 상세 + 수정
class PostRetrieveUpdateView(generics.RetrieveAPIView, generics.UpdateAPIView, generics.DestroyAPIView):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

#게시글 수정
#class PostUpdateView(generics.UpdateAPIView):
#    queryset = Post.objects.all()
#    serializer_class = PostListSerializer

@api_view
def calculator(request):
    num1=request.GET.get('num1', 0)
    num2=request.GET.get('num2', 0)
    operators=request.GET.get('operators')

    if operators=='+':
        result=int(num1)+int(num2)
    elif operators=='-':
        result=int(num1)-int(num2)
    elif operators=='*':
        result=int(num1)*int(num2)
    elif operators=='/':
        result=int(num1)/int(num2)
    else:
        result=0

    data = {
        'type' : 'FBW',
        'result' : result
    }

    return Response(data)


def index(request):
    post_list = Post.objects.all().order_by('-created_at')
    context = {
        'post_list' : post_list,
    }
    return render(request, 'index.html', context)

def post_list_view(request):
    post_list = Post.objects.filter(writer=request.user)
    context = { #Post 객체를 리스트 형태로 담기
        'post_list':post_list,
    }
    return render(request, 'posts/post_list.html', context)

def post_detail_view(request, id):
    try:
        post = Post.objects.get(id=id)
    except Post.DoesNotExist:
        return redirect('index')
    post = Post.objects.get(id=id)
    context = {
        'post':post,
        'form':PostDetailForm(),
    }
    return render(request, 'posts/post_detail.html', context)

def post_create_view(request):
    if request.method == 'GET':
        return render(request, 'posts/post_form.html')
    else:
        image = request.FILES.get('image')
        content = request.POST.get('content')
        Post.objects.create(
            image=image,
            content=content,
            writer = request.user
        )
        return redirect('index')

def post_create_form_view(request):
    if request.method == "GET":
        form = PostCreatedForm()
        context = {'form':form}
        return render(request, 'posts/post_form2.html', context)
    else:
        form = PostCreatedForm(request.POST, request.FILES)

        if form.is_vaild():
            Post.objects.create(
                image=form.cleaned_data['image'],
                content=form.cleaned_data['content'],
                writer=request.user
        )
        else:
            return redirect('post:post-create')
        return redirect('index')

def post_update_view(request, id):
    return render(request, 'posts/post_update.html')

def post_delete_view(request, id):
    return render(request, 'posts/post_confirm_delete.html')

class class_view(ListView):
    model = Post
    template_name = 'cbv_view.html'

def url_view(request):
    data = {'code': '001', 'msg': 'OK'}
    return HttpResponse('<h1>url_views</h1>')

def url_parameter_view(request, username):
    print(f'url_parameter_view()')
    print(f'username: {username}')
    print(f'request.GET: {request.GET}')
    return HttpResponse(username)

def function_view(request):
    print(f'request.method: {request.method}')

    if request.method == "GET":
        print(f'request.GET: {request.GET}')
    elif request.method == 'POST':
        print(f'request.POST: {request.POST}')
    return render(request, 'view.html')