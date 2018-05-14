import requests

entrada = input("Digite uma URL:")
r = requests.get(entrada)
print("Status code: ", str(r.status_code))
print("Header: ", r.headers.__str__())
print("Tamanho: ", r.headers['content-length'])