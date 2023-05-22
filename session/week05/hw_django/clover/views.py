from django.shortcuts import render
from django.http import HttpResponse

def helloBabyLion(request):
    return render(request, 'findclover.html')