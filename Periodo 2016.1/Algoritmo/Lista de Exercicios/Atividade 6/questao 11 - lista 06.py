#-*- coding: utf-8 -*-

'''
 Um dos recursos disponibilizados pelos editores de texto mais modernos é a contagem da quantidade de palavras de um texto. 
 Escreva um programa que determine o numero de palavras de um texto digitado.
 '''

def main():
	texto = raw_input('digite um texto: ')
	palavra = texto.replace(' ', '')
	print len(palavra)


if __name__ == '__main__':
	main()
