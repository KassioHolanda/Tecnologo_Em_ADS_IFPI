# -*- coding: utf-8 -*-
"""
Leia um número e divida-o por dois  (sucessivamente) até que o resultado seja menor que 1.
Escreva o resultado da última divisão efetuada.
"""
numero =  int(input('Digite um número: '))

while numero >= 1:
    numero = numero/2.0
    print('%.1f' % numero)


