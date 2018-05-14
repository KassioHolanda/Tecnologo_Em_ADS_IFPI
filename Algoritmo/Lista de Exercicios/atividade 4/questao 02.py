#-*- coding: utf-8 -*-

num1 = int(input("digite o primeiro numero: "))
num2 = int(input("digite o segundo numero: "))
contador = num1

while contador%num1 != 0 or contador%num2 != 0:
	contador += 1

print "o mmc de {} e {} é igual a :{}" .format (num1,num2,contador)