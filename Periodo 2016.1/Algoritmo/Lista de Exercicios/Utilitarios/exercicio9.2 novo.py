from questao import has_no_e


def main():
	arquivo = open('words.txt')
	for linha in arquivo:
		palavra = linha.strip()
		if has_no_e(palavra):
			print palavra

if __name__ == '__main__':
	main()