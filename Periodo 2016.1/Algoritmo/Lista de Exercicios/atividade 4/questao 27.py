#-*- coding: utf-8 -*-

'''
Escreva um algoritmo que leia um conjunto de dados de um grupo de 100 pessoas, sexo (1=Masculino,
2=Feminino), idade e estado civil (1=Casado, 2=Solteiro, 3=Divorciado, 4=Viúvo) e escreva:
· Média de idade das mulheres;
· Média de idade dos homens;
· O percentual de homens solteiros;
· O percentual de mulheres solteiras;
· A quantidade de mulheres divorciadas acima de 30 anos.
'''

def main():
	pessoas = 0
	sexo = 0
	sexo_m = 0
	sexo_f = 0
	m_solt = 0
	f_solt = 0
	acima_t = 0
	estado_civil = 0
	s_a_t = 0
	p_f_s = 0
	p_m_s = 0
	while pessoas < 2:
		
		print'digite apenas o que sera pedido.'
		
		print'qual sua idade?'
		idade = input('idade: ')
		if idade >= 30:		
			acima_t = acima_t + 1
		print'qual seu sexo; (1) para masculino e (2) para feminino'
		sexo = input('opção: ')
		if sexo == 1:
			print'qual seu estado civil; digite (1) para casado, (2) para solteiro, (3) para divorciado e (4) para viuvo'
			estado_civil = input('estado civil: ')
			if estado_civil == 2:
				m_solt = m_solt + 1
			sexo_m = sexo_m + 1
		if sexo == 2:
			print'qual seu estado civil; digite (1) para casado, (2) para solteiro, (3) para divorciado e (4) para viuvo'
			estado_civil = input('estado civil: ')
			if idade >= 30:
				if estado_civil == 3:
					s_a_t = s_a_t + 1
			if estado_civil == 2:
				f_solt = f_solt + 1
			sexo_f = sexo_f + 1
		pessoas+=1
	p_f_s = (f_solt/pessoas)
	p_m_s = (m_solt/pessoas)






	print'A media de idades das mulheres é de: %2.f' % (sexo_f/100)
	print'A media de idades dos homens é de: %.2f' % (sexo_m/100)
	print'o percentual de mulheres solteiras é de %.2f' % p_f_s
	print'o porcentual de homens solteros é de %d' p_m_s
	print 'o numero de mulheres divorciadas acima de trinta anos é de %d' % acima_t


if __name__ == '__main__':
	main()


