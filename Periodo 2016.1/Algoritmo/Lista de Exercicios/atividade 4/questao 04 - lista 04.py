#-*- coding: utf-8 -*-

#Leia um número e divida-o por dois  (sucessivamente) até que o resultado seja menor que 1. Escreva o resultado da última divisão efetuada

def numeros(num):
	while num > 1:
		num = num / 2.0
		print "a divisao do numero: %.2f" %  num
	else: 
		print "a ultima divisao sera %.2f" % num


		

def main():
	num = float(input("digite um numero: "))
	numeros(num)

if __name__ == "__main__":
        main()
