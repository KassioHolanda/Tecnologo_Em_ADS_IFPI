#coding:utf-8
'''
Escreva um programa que leia três valores com ponto flutuante de dupla precisão: A, B e C. 
Em seguida, calcule e mostre: 
a) a área do triângulo retângulo que tem A por base e C por altura. 
b) a área do círculo de raio C. (pi = 3.14159) 
c) a área do trapézio que tem A e B por bases e C por altura. 
d) a área do quadrado que tem lado B. 
e) a área do retângulo que tem lados A e B. 
Entrada

O arquivo de entrada contém três valores com um dígito após o ponto decimal.

Saída

O arquivo de saída deverá conter 5 linhas de dados. Cada linha corresponde a uma das áreas descritas acima, 
sempre com mensagem correspondente e um espaço entre os dois pontos e o valor. 
O valor calculado deve ser apresentado com 3 dígitos após o ponto decimal.
'''
from math import pow
pi = 3.14159
def main():
	valores = ([float(i) for i in raw_input().split()])
	triangulo = (valores[0] * valores[2])/2
	circulo = pi*(pow(valores[2],2))
	trapezio = ((valores[0] + valores[1])*valores[2])/2
	quadrado = pow(valores[1],2)
	retangulo = valores[0]*valores[1]

	print'TRIANGULO: %.3f\nCIRCULO: %.3f\nTRAPEZIO: %.3f\nQUADRADO: %.3f\nRETANGULO: %.3f' % (triangulo, circulo,trapezio,quadrado,retangulo)


if __name__ == '__main__':
	main()