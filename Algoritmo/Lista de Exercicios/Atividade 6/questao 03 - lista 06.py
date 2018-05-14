#-*- coding: utf-8 -*-

#Leia uma frase e gere uma nova frase, retirando os espaços entre as palavras

def main():
	frase = raw_input('digite uma frase: ')
	palavras = frase.replace(' ', '')
	print palavras


if __name__=='__main__':
        main()
