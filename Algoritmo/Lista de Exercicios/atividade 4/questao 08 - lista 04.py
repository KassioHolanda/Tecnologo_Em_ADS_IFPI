# -*- coding: utf-8 -*-


#Leia um numero X e, a seguir, leia e escreva uma lista de números com o término da
#lista ocorrendo quando a soma de dois números consecutivos da lista for igual a X.

x = input("digite um numero:")
list = 0
list_n = 0
while list + list_n <= x:
    print list,
    list_n = list
    list+= 1
