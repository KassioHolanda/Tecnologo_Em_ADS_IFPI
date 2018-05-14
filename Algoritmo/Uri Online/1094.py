#coding:utf-8

def main():
	N = int(input())
	contador = 0

	ratos = 0.0
	sapos = 0.0
	coelhos = 0.0
	total = 0.0

	while contador != N:
		entrada = [(i) for i in raw_input().split()]
		if entrada[1].upper() == 'C':
			coelhos = coelhos + (int(entrada[0]))
			total = total + (int(entrada[0]))

		elif entrada[1].upper() == 'R':
			ratos = ratos + (int(entrada[0]))
			total = total + (int(entrada[0]))

		elif entrada[1].upper() == 'S':
			sapos = sapos + (int(entrada[0]))
			total = total + (int(entrada[0]))

		contador+=1

	percentual_coelhos = float((coelhos/total)*100.0)
	percentual_ratos = ((ratos/total)*100)
	percentual_sapos = ((sapos/total)*100)

	print'Total: %d cobaias' % total
	print'Total de coelhos: %d' % coelhos
	print'Total de ratos: %d' % ratos
	print'Total de sapos: %d' % sapos
	print'Percentual de coelhos: %.2f %%' % percentual_coelhos
	print'Percentual de ratos: %.2f %%' % percentual_ratos
	print'Percentual de sapos: %.2f %%' % percentual_sapos

if __name__ == '__main__':
	main()
