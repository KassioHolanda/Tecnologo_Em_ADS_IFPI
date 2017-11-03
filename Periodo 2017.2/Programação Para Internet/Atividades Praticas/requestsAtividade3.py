import requests
import re

url = input("Digite uma URL:")
r = requests.head(url=url)
print(r.headers['link'])