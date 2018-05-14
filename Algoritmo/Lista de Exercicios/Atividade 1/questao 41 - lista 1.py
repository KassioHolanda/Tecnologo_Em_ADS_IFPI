#-coding: utf-8 -*-

'''
O custo ao consumidor de um carro novo é a soma do custo de fábrica com a percentagem do
distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que a percentagem do distribuidor
seja de 28% e os impostos de 45%, escreva um algoritmo que leia o custo de fábrica de um carro e
escreva o custo ao consumidor.
'''

def main():
	custo = input('digite o custo do carro que voce deseja comprar: ')
	custo_n = (custo * 0.28) + (custo * 0.45) + custo

	print'o custo do veiculo com todos os impostos sera de %d' % custo_n



if __name__ == '__main__':
	main()