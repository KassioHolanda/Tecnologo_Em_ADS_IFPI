from django.core.serializers import json

arq = open('db.json', 'r')
for i in arq:
    dado = json.dumps(arq)
    print(dado)