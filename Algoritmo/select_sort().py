def main():
	dados = [int(i) for i in raw_input().split()]
	for i in range(len(dados) -1):
		menor = i
		for j in range(i+1, len(dados)):
			if dados[j] < dados[menor]:
				menor = j
		dados_n = dados[i]
		dados[i] = dados[menor]
		dados[menor] = dados_n
	print dados 

if __name__ == '__main__':
	main()