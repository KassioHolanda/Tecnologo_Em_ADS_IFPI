#coding:utf-8
'''
Leia quatro valores inteiros A, B, C e D. A seguir, 
calcule e mostre a diferença do produto de A e B pelo produto de C e D segundo a fórmula: 
DIFERENCA = (A * B - C * D).

Entrada

O arquivo de entrada contém 4 valores inteiros.

Saída

Imprima a mensagem DIFERENCA com todas as letras maiúsculas, 
conforme exemplo abaixo, com um espaço em branco antes e depois da igualdade.
'''

def main():
	valor_A = input()
	valor_B = input()
	valor_C = input()
	valor_D = input()

	DIFERENCA = (valor_A*valor_B - valor_C*valor_D)

	print'DIFERENCA = %d' % DIFERENCA
if __name__ == '__main__':
	main()