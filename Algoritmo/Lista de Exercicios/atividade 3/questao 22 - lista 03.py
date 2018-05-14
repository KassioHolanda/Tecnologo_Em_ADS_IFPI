#-*- coding: utf-

'''
Um fazendeiro possui fichas de controle sobre sua boiada. Cada ficha contém numero de identificação,
nome e peso (em kg) do boi. Escreva um algoritmo que leia os dados de N fichas e ao final, escreva o
numero de identificação e o peso do boi mais magro e do boi mais gordo.
'''

def main():
	ficha = 1
	boi_pesado = 0.0
	boi_magro = 10000000000.0
	print'digite corretamente os dados para a ficha do gado.'
	print'digite (0) para terminar o registro'
	print'--------------------------------------------------------------------'
	peso = input('qual o peso do boi em Kg: ')
	continuar = input('deseja continuar, digite (1) para sim e (0) para nao.')
	while continuar != 0:
		if peso > boi_pesado:
			boi_pesado = peso
		if boi_magro > peso:
			boi_magro = peso
		ficha = ficha + 1
		peso = input('qual o peso do boi em Kg: ')
		continuar = input('deseja continuar, digite (1) para sim e (0) para nao.')

	print'---------------------------------------------------------------------------------'
	print'*********************************************************************************'
	print'o numero de fichas cadastradas é de %d' % ficha
	print'ficha numero: %d, com peso de %.2f Kg' % (ficha, peso)
	print 'o boi mais pesado pesa %,2f Kg' % boi_pesado
	print'o boi mais magro pesa %.2f Kg' % boi_magro

if __name__ == '__main__':
	main()