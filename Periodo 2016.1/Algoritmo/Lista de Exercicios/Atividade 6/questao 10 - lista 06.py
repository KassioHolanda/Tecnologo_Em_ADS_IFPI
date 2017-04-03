#-*- coding: utf-8 -*-


'''
Uma palavra é palíndroma se ela não se altera quando lida da direita para esquerda. Por exemplo, raiar
é palíndroma. Escreva um programa que verifique se uma palavra digitada é palíndroma
'''

def main():
	palavra = raw_input('digite uma palavra: ')
	if palavra  == palavra[::-1]:
		print'essa palavra é palindroma'
	else:
		print'essa palavra nao é palindroma'


if __name__ == '__main__':
	main()