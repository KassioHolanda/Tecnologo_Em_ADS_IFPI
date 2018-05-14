

'''
Leia um vetor A com N elementos e escreva um vetor B, com os mesmos elementos de A, sendo que 
estes  deverão  estar  invertidos,  ou  seja,  o  1º  elemento  de  A  deve  ser  o  último  elemento  de  B;  o  2º 
elemento de A deve ser o penúltimo elemento de B e assim por diante.
'''

def main():
	numeros = input('digite a quantidade de numeros da lista: ')
	lista = range(numeros)
	print lista[::-1]


if __name__ == '__main__':
	main()