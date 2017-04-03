def main():
	lista = range(100)
	lista.sort()
	contador = 0
	numero = input()
	for i in range(len(lista)):
		if numero == lista[i]:
			print 's'
			break
	else:
		print 'sa'

if __name__ == '__main__':
	main()
