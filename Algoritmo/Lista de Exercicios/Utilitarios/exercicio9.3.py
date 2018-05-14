#-*- coding: utf-8 -*-

'''
Escrever uma função chamada evita que leva uma palavra e uma seqüência de letras proibidos, 
e que retorna True se a palavra não usar qualquer uma das cartas proibidas.
Modificar o programa para solicitar que o usuário digite uma seqüência de letras proibidos e, em seguida, 
imprimir o número de palavras que não contêm qualquer um deles. você pode encontrar uma combinação de 5 cartas proibidas que exclui o menor número de palavras?
'''

from questao import avoids

def main():
	arquivo = open('words.txt')
	contador_geral = 0
	contador_avoids = 0

	letras_proibidas = raw_input('letras proibidas: ')


	for linha in arquivo:
		contador_geral = contador_geral + 1
		palavra = linha.strip()
		if avoids(palavra, letras_proibidas):
			contador_avoids = contador_avoids + 1

if __name__ == '__main__':
        main()
