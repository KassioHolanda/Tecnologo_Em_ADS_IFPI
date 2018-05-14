def main():
	N = input()
	for i in range(N):
		num_alunos = input()
		alunos = [i for i in input().split()]
		alunos = int(alunos)
		novo_alunos = (sorted(alunos, reverse=True))
		contador = 0
		for j in range(num_alunos):
			if alunos[j] == novo_alunos[j]:
				contador += 1
		print(contador)

if __name__ == '__main__':
	main()