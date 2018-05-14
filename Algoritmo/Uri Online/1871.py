def main():
	while True:
		lista = [int(i) for i in raw_input().split()]
		if lista[0] == 0 and lista[1] == 0:
			break
		else:	
			soma = (lista[0] + lista[1])
			soma = str(soma)
			soma = soma.replace('0', '')
			print '%s' % soma

if __name__ == '__main__':
	main()