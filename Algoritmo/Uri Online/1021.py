#coding:utf-8
'''
Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor monetário. 
A seguir, calcule o menor número de notas e moedas possíveis no qual o valor pode ser decomposto. 
As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. 
A seguir mostre a relação de notas necessárias.
Entrada

O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).
Saída

Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial, conforme exemplo fornecido.
'''
def main():
	moedas_50 = 0
	moedas_25 = 0
	moedas_10 = 0
	moedas_5 = 0
	moedas_01 = 0

	valor = float(input())
	
	notas_100 = int(valor/100)
	resto_100 = int(valor%100)
	
	notas_50 = int(resto_100/50)
	resto_50 = int(resto_100%50)
	
	notas_20 = int(resto_50/20)
	resto_20 = int(resto_50%20)
	
	notas_10 = int(resto_20/10)
	resto_10 = int(resto_20%10)
	
	notas_5 = int(resto_10/5)
	resto_5 = int(resto_10%5)
	
	notas_2 = int(resto_5/2)
	resto_2 = int(resto_5%2)

	moedas_1 = int(resto_2/1)

	moedas = ((float(valor))-(int(valor)))
	
	if moedas >= 0.50:
		while moedas >= 0.50:
			moedas_50 += 1
			moedas -= 0.50
	if moedas >= 0.25:
		while moedas >= 0.25:
			moedas_25 += 1
			moedas -= 0.25
	if moedas >= 0.10:
		while moedas >= 0.10:
			moedas_10 += 1
			moedas -= 0.10
	
	moedas = int(moedas*100)

	while moedas >= 5:
		moedas_5 += 1
		moedas -= 5
	
	while moedas >= 1:
		moedas_01 += 1
		moedas -= 1 

	print'NOTAS:'
	print '%i nota(s) de R$ 100.00' % notas_100
	print '%i nota(s) de R$ 50.00' % notas_50
	print '%i nota(s) de R$ 20.00' % notas_20
	print '%i nota(s) de R$ 10.00' % notas_10
	print '%i nota(s) de R$ 5.00' % notas_5
	print '%i nota(s) de R$ 2.00' % notas_2
	print'MOEDAS:'
	print '%i moeda(s) de R$ 1.00' % moedas_1
	print '%i moeda(s) de R$ 0.50' % moedas_50
	print '%i moeda(s) de R$ 0.25' % moedas_25
	print '%i moeda(s) de R$ 0.10' % moedas_10
	print '%i moeda(s) de R$ 0.05' % moedas_5
	print '%i moeda(s) de R$ 0.01' % moedas_01


if __name__ == '__main__':
	main()
