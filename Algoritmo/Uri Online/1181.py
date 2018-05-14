def main():
	L = input()
	T = raw_input()
	soma = 0
	matriz = []

	for i in range(12):
		linha = []
		for j in range(12):
			celula = input()
			linha.append(celula)
		matriz.append(linha)

	for i in matriz[L]:
		soma += i
	
	media = (soma/12)

	if T == 'S':
		print '%.1f' % soma

	if T == 'M':
		print '%.1f' % media

if __name__ == '__main__':
	main()