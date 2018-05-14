# -*- coding: utf-8 -*-


valorA = int(input("digite o primeiro numero inteiro: "))
valorB = int(input("digite o segundo numero inteiro: "))
valorC = int(input("digite o terceiro numero inteiro: "))
valorD = int(input("digite o quarto numero inteiro: "))

somaCD = valorC + valorD
somaAB = valorA + valorB

if valorC > valorA and somaCD > somaAB and valorD > 0 and valorC > 0 and valorA%2 == 0:
	print "valores aceitos"
else: 
	print "valores nao aceitos"
