def por_tamanho(vetor):
	return (len(vetor))

def main():
	N = input()
	novo_vetor = []
	a = []
	for i in range(N):
		vetor = raw_input().split()
		vetor = (sorted(vetor, key=por_tamanho))
		novo_vetor.append(vetor[::-1])
	for i in novo_vetor:
		print i

if __name__ == '__main__':
	main()