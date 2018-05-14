#coding: utf-8
#Leia 1 (um) número de 2 (dois) dígitos, verifique e escreva se o algarismo da dezena é igual ou diferente do algarismo da unidade. 

def numero(num1):
	if num1 / 10 == num1 % 10:
		print "a dezena é igual a unidade"
	else:
		print "os numeros sao diferente"

def main():
	num1 = int(input("digite um numero inteiro de dois digitos: "))
	numero(num1)

if __name__ == '__main__':
	main()
