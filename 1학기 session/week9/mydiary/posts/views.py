from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from django.views.generic import ListView
from .models import Post

# Create your views here.

def url_view(request):
    print(f'request.method : {request.method}')

    if request.method == "GET" :
        print(f'request.GET : {request.GET} ')
    elif request.method == "POST":
        print(f'request.POST : {request.POST}')
    return render(request, 'introview.html')

class class_view(ListView):
    model = Post
    template_name = 'write_view.html'