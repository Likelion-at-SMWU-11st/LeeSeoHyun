from django.shortcuts import render

def signup_view(request):
    if request.method == 'GET':
        form = None
        context = {'form':form}
        return render(request, 'accounts/signup.html', context)
    else:
        pass