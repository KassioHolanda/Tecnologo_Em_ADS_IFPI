# -*- coding: utf-8 -*-
numero = input("digite um valor para numero: ")
contador = 0

def numeros(contador, numero):
        for num in range(contador, numero + 1 ):
        	total = contador + num
        	contador += num
        return contador

print(numeros(contador, numero))



