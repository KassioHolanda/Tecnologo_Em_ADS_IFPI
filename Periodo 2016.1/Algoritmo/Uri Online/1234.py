#coding:utf-8

def main():
	palavras = raw_input()
	for letra in palavras:
		for i in range(len(palavras)):
			print letra[i]


if __name__ == '__main__':
	main()