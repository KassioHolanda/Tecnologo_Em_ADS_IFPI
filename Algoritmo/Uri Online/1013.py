def main():
	lista = [int(i) for i in raw_input().split()]
	a = lista[0]
	b = lista[1]
	c = lista[2]

	maiorAB = (a+b+abs(a-b))/2

	print maiorAB

if __name__ == '__main__':
	main()
