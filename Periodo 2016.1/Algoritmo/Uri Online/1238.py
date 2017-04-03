def main():
	N = input()
	palavra = []
	for x in range(N):
		lista = [i for i in raw_input().split()]
		palavra.append(juntar_palavras(lista))
	for i in palavra:
		print i

def juntar_palavras(lista):
	palavra = ''
	contador = 0
	if len(lista[1]) > len(lista[0]):
		for i in range(len(lista[0])):
			if contador == 0:
				palavra += lista[0][i]
				contador += 1
			if contador == 1:
				palavra += lista[1][i]
				contador -= 1
		for j in range(len(lista[0]),len(lista[1])):
			palavra += lista[1][j]

	elif len(lista[1]) < len(lista[0]):
		for i in range(len(lista[1])):
			if contador == 0:
				palavra += lista[0][i]
				contador += 1
			if contador == 1:
				palavra += lista[1][i]
				contador -= 1
		for j in range(len(lista[1]),len(lista[0])):
			palavra += lista[0][j]
	else:
		for i in range(len(lista[1])):
			if contador == 0:
				palavra += lista[0][i]
				contador += 1
			if contador == 1:
				palavra += lista[1][i]
				contador -= 1

	return palavra


if __name__ == '__main__':
	main()


