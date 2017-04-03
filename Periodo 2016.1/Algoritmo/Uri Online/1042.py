def main():
	vetor = []	
	novo_vetor = []
	for i in range(3):
		numero = input()
		vetor.append(numero)
		novo_vetor.append(numero)
		vetor.sort()


	print '%i\n%i\n%i\n' % (vetor[0], vetor[1], vetor[2])
	print '%i\n%i\n%i' % (novo_vetor[0], novo_vetor[1], novo_vetor[2])

if __name__ == '__main__':
      main()