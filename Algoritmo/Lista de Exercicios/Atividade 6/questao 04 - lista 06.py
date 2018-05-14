#-*- coding: utf-8 -*-

#Leia uma frase e gere uma nova frase, duplicando cada caractere da frase digitada.

def main():
	frase = raw_input('digite uma frase: ')
	for letra in frase:
			print letra, letra,

if __name__ == '__main__':
	main()
