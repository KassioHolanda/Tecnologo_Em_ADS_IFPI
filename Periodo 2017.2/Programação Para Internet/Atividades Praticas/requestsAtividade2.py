import io
import requests
import shutil

url = input("DIgite uma url: ")
response = requests.get(url, stream=True)
with open('img.jpg', 'wb') as out_file:
    shutil.copyfileobj(response.raw, out_file)
del response
