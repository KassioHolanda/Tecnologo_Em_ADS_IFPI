from questao import uses_all

def main():
	letras = raw_input('letras: ')
	arquivo = open('words.txt')
	contador_all = 0

	for linha in arquivo:
		palavra = linha.strip()
		if uses_all(palavra, letras):
			contador_all += 1
			print palavra

	print 'qtd de palavras %d' % contador_all



if __name__ == '__main__':
	main()
