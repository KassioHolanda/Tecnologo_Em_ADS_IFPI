#coding:utf-8
'''
Neste problema, deve-se ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o código de uma peça 2, 
o número de peças 2 e o valor unitário de cada peça 2. Após, calcule e mostre o valor a ser pago.

Entrada

O arquivo de entrada contém duas linhas de dados. Em cada linha haverá 3 valores, 
respectivamente dois inteiros e um valor com 2 casas decimais.

Saída

A saída deverá ser uma mensagem conforme o exemplo fornecido abaixo, 
lembrando de deixar um espaço após os dois pontos e um espaço após o $. 
O valor deverá ser apresentado com 2 casas após o ponto.
'''
def main():
	peca_1 = ([float(i) for i in raw_input().split()])
	peca_2 = ([float(i) for i in raw_input().split()])
	pagar_peca_1 = int(peca_1[1]) * float(peca_1[2])
	pagar_peca_2 = int(peca_2[1]) * float(peca_2[2])


	print'VALOR A PAGAR: R$ %.2F' % (pagar_peca_2 + pagar_peca_1)
	


if __name__ == '__main__':
	main()


