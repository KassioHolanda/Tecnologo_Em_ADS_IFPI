#coding:utf-8
'''
Entrada

A entrada contém vários casos de teste. Cada teste começa com um valor N (1 ≤ N ≤ 1000). 
Em seguida, N linhas terão os códigos dos livros, que estão sempre no formato "xxxx", 
isto é, não haverá o cadastro '1', por exemplo, mas "0001". A entrada termina com fim de arquivo.
Saída

Seu programa deverá imprimir o cadastro dos códigos ordenado. Não haverá linha em branco entre os casos de teste.
'''
def main():
	biblioteca = []
	nova_biblioteca = []
	while True:
		try:
			numeros = input()
			for i in range(numeros):
				livro = raw_input()
				biblioteca.append(livro.zfill(4))
			biblioteca.sort()
			for livros in biblioteca:
				nova_biblioteca.append(livros)
			biblioteca = []

		except:
			for livros in nova_biblioteca:
				print livros
			break
		
if __name__ == '__main__':
	main()

