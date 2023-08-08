from django.db import models
from django.shortcuts import render
from .forms import UserCreateForm

def signup_view(request):
    if request.method == 'GET':
        form = UserCreateForm
        context = {'form' : form}
        return renter(request, 'accounts/signup.html', context)

    else:
        pass