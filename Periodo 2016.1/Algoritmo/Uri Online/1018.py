def main():
	n_valor = int(input())
	
	valor = n_valor

	notas_100 = 0
	notas_50 = 0
	notas_20 = 0
	notas_10 = 0
	notas_5 = 0
	notas_2 = 0
	notas_1 = 0

	while valor >= 100:
		notas_100 += 1
		valor = valor - 100
	while valor >= 50:
		notas_50 += 1
		valor = valor - 50
	while valor >= 20:
		notas_20 += 1
		valor = valor - 20
	while valor >= 10:
		notas_10 += 1
		valor = valor - 10
	while valor >= 5:
		notas_5 += 1
		valor = valor - 5
	while valor >= 2:
		notas_2 += 1
		valor = valor - 2
	while valor >= 1:
		notas_1 += 1
		valor = valor - 1

	print '%i' % n_valor
	print '%i nota(s) de R$ 100,00' % notas_100
	print '%i nota(s) de R$ 50,00' % notas_50
	print '%i nota(s) de R$ 20,00' % notas_20
	print '%i nota(s) de R$ 10,00' % notas_10
	print '%i nota(s) de R$ 5,00' % notas_5
	print '%i nota(s) de R$ 2,00' % notas_2
	print '%i nota(s) de R$ 1,00' % notas_1

if __name__ == '__main__':
	main()
