# -*- coding: utf-8 -*-
#Leia 1 (um) número inteiro e escreva se este número é par ou impar. 

def numero(num):
	if num % 2 == 0:
		print "o número é par"
	else: 
		print "o numero é impar"

def main():
	num = int(input("digite um numero: "))
	numero(num)

if __name__ == '__main__':
	main()