# -*- coding: utf-8 -*-

#Leia 2 números inteiros e escreva a multiplicação dos mesmos, sem que o operador de multiplicação (*) seja utilizado.

valor1 = input("informe o valor um: ")
valor2 = input("informe o valor dois: ")

multi = 0

while valor2 >= 1:
	multi += valor1
	valor2 -= 1

print "a multiplicação dos dois dois numeros é %d" % multi