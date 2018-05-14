def main():
	N = input()
	vetor = []
	for i in range(N):
		frase = raw_input()
		metade = (len(frase)/2) - 1
		total = len(frase)
		inverso_I = frase[:metade:-1]
		inverso_F = frase[metade::-1]

		frase_full = inverso_F + inverso_I
		vetor.append(frase_full)

	for i in vetor:
		print i


if __name__ == '__main__':
	main()