
#-*- coding: utf-8 -*-
#Escreva um programa que receba um nÃºmero inteiro A e outro numero inteiro B, ambos menores que 10. Em seguida

#escreva recursivamente a tabuada das quatro operadores bÃ¡sicas de A, todas iniciando em B

def numeros(a,b):
	if a and b > 10:
		print "FIM"
	else:
		resultado = "som", b + a, "mult", b * a, "subt", b - a, "div", b/a
		print "o resultado de todas as operaÃ§Ãµes matematicas sao: ", resultado
		numeros(a+1,b+1)

def main():
	a = int(input("digite um numero para a: "))
	b = int(input("digite um numero para b: "))
	numeros(a,b)

if __name__ == '__main__':
	main()
