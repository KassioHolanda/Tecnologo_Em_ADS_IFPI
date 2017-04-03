#coding:utf-8

'''
Faça um algoritmo para ler um número indeterminado de dados, contendo cada um, a idade de um indivíduo. 
O último dado, que não entrará nos cálculos, contém o valor de idade negativa. Calcular e imprimir a idade média deste grupo de indivíduos.
Entrada

A entrada contém um número indeterminado de inteiros. A entrada será encerrada quando um valor negativo for lido.
Saída

A saída contém um valor correspondente à média de idade dos indivíduos.

A média deve ser impressa com dois dígitos após o ponto decimal.
'''

def main():
	total_idade = 0
	idade = input()
	contador = 1
	total_idade = float(idade + total_idade)
	while idade > 0:
		idade = input()
		if idade > 0:
			total_idade = float(idade + total_idade)
			contador = contador + 1
		else:
			print '%.2f' % (total_idade/contador)

if __name__ == '__main__':
	main()




