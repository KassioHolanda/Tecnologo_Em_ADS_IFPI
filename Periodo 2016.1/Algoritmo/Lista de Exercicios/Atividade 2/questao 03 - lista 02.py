#coding: utf-8
#Leia 3 (três) números, verifique e escreva o maior entre os números lidos

def numeros(num1,num2,num3):
	if num1>num2>num3:
		print"%.1f é o maior numero" % (num1)
	elif num2>num1>num3:
		print"%.1f é o maior numero" % (num2)
	elif num3>num1>num2:
		print"%.1f é o maior numero" % (num3)
	else: 
		print "voce digitou numeros iguais"

def main():
	num1 = float(input("digite o primeiro numero: "))
	num2 = float(input("digite o segundo numero: "))
	num3 = float(input("digite o terceuri numero: "))
	numeros(num1,num2,num3)

if __name__ == '__main__':
	main()