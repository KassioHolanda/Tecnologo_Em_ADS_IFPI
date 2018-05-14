def main():
	N = input()
	novo_vetor = ''
	contador = 0
	for i in range(N):
		vetor = raw_input().split()
		#tamanho = contagem(vetor)
		for i in vetor:
			contador = contador + 1
		for i in range(contador-1):
			contador_1 = 0
			contador_2 = 0
			for j in vetor[i]:
				contador_1 += 1
			for x in vetor[i]:
				contador_2 += 1
			if contador_1 > contador_2:
				novo_vetor += vetor[i]

	print novo_vetor


def contagem(vetor):
	contador = 0
	for i in vetor:
		contador += 1
			

if __name__ == '__main__':
	main()