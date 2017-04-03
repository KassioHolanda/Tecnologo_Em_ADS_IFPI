#-*- coding: utf-8 -*-

'''
Write a program that reads words.txt and prints only the words with more than 20
characters (not counting whitespace)
'''




def main():

	arquivo = open('words.txt')

	for linha in arquivo:
		palavra = linha.strip()
		if len(palavra) > 20:
			print linha.strip()


if __name__ == '__main__':
	main()