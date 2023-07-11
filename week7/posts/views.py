from django.shortcuts import render
import random
from .models import Game

def lotto(request):
    lotto_number = list()
    for _ in range(7):
        lotto_number.append(random.randint(1, 45))
    return render(request, 'lotto.html', {'lotto_number' : lotto_number})

def result(request):
    global game_num
    game_num = request.GET.get('game_set','')
    return render(request, 'result.html', {'game_num' : game_num})

def lotto_index(request):
    lotto_list = list()

    for i in range(game_num):
        line = []
        for j in range(7):
            line.append(random.randint(1, 45))
        lotto_list.append(line)
        
    return render(request, 'result.html', {"lotto_list" : lotto_list})