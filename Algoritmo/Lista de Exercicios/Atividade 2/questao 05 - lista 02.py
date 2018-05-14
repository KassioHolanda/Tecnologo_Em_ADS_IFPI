#-*- coding: utf-8 -*-
#Leia 3 (três) números e escreva-os em ordem crescente. 

def numeros(num1,num2,num3):
	if num1<num2<num3:
		print "a ordem crescente fica", num1, num2, num3
	elif num1<num3<num2:
		print "a ordem crescente fica", num1, num3, num2
	elif num2<num1<num3:
		print "a ordem crescente fica", num2, num1, num3
	elif num2<num3<num1:
		print "a ordem crescente fica", num2, num3, num1
	elif num3<num1<num2:
		print "a ordem crescente fica", num3, num1, num3
	elif num3<num2<num1:
		print "a ordem crescente fica", num3, num2, num1
	else:
		print "digite numeros diferentes"


def main():
	num1 = float(input("digite o primeiro número: "))
	num2 = float(input("digite o segundo número: "))
	num3 = float(input("digite o terceuri número: "))
	numeros(num1,num2,num3)

if __name__ == '__main__':
	main()
