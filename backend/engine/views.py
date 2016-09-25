from django.http import JsonResponse
import models
import json


# request.user <- contrib.auth.User
# request.auth <- token

def units_by_serial(request):
    if request.method == 'GET':
        string = json.load(request.body)['sid']
        units = models.Unit.objects.filter(serial__startswith=string)
        result = []
        for i in xrange(len(units)):
            result[i] = str(units[i].serial)
        return JsonResponse(result)







