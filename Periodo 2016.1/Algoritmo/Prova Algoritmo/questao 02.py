def main():
	vetor = [int(i) for i in raw_input().split()]
	if len(vetor) <= 1:
		print vetor
	else:
		for i in range(0, len(vetor)):
			for j in range(0, len(vetor)-1):
				if vetor[j] > vetor[j+1]:
					vetor_n = vetor[j+1]
					vetor[j+1] = vetor[j]
					vetor[j] = vetor_n
		print vetor
	
if __name__ == '__main__':
	main()