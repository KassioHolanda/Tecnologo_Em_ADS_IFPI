'''
Uma determinada empresa armazena para cada funcionário uma ficha contendo o código, o número de
horas trabalhadas e o seu nº de dependentes. Considerando que a empresa paga R$ 12,00 por hora e R$
40,00 por dependentes e que sobre o salário são feitos descontos de 8,5%% para o INSS e 5%% para IR.
Escreva um algoritmo que leia o código, número de horas trabalhadas e número de dependentes de N
funcionários. Após a leitura de cada ficha, escreva os valores descontados para cada imposto e o salário
líquido do funcionário.
'''


def main():
	salario_f = 0
	inss = 0.85
	ir = 0.05
	unid_hora = 12.00
	unid_depen = 40.00
	horas = input('digite o numer de horas de trabalho: ')
	dependentes = input('digite o numero de dependetes: ')
	funcionarios = input('digite o numero de funcionarios: ')
	salario_f = (horas * unid_hora) + (unid_depen * dependentes) - inss - ir


	print salario_f

	
if __name__ == '__main__':
	main()