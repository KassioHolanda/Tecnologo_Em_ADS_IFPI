#-*- coding: utf-8 -*-]
'''Leia um número e, a seguir, leia uma lista de números até achar um igual ao primeiro número lido.'''
numero = int(input('Informe um número: '))
list = 0
while list < numero:
    print('Ainda não encontrei... estamos no número %d' % list)
    list += 1
print('Ufa, encontrei... o número digitado %d' % numero)


