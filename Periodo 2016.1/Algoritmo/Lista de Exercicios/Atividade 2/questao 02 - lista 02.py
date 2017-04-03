# -*- coding: utf-8 -*-


#Leia 2 (dois) números, verifique e escreva o menor e o maior entre os números lidos. 

def numeros(num1,num2):
	if num1 > num2:
		print "%.1f é maior que %.1f" % (num1,num2)
	else:
		print "%.1f é menor que %.1f" % (num1,num2)

def main():
	num1 = float(input("digite o primeiro numero: "))
	num2 = float(input("digite o segundo numero: "))
	numeros(num1,num2)

if __name__ == '__main__':
	main()
