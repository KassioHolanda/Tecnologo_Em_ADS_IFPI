#coding:utf-8
'''
Leia 4 valores inteiros A, B, C e D. A seguir, se B for maior do que C e se D for maior do que A, 
e a soma de C com D for maior que a soma de A e B e se C e D, ambos, 
forem positivos e se a variável A for par escrever a mensagem "Valores aceitos", senão escrever "Valores nao aceitos".

Entrada

Quatro números inteiros A, B, C e D.

Saída

Mostre a respectiva mensagem após a validação dos valores.
'''
def main():
	lista = [int(i) for i in raw_input().split()]
	if (lista[1]>lista[2]) and (lista[3]>lista[0]) and ((lista[2]+lista[3])>(lista[0]+lista[1])) and (lista[2]>0) and (lista[3]>0) and (lista[0]%2 == 0):
		print'Valores aceitos'
	else:
		print'Valores nao aceitos'


if __name__ == '__main__':
	main()