#coding:utf-8
'''
Leia um vetor A com N elementos, verifique e escreva se existem ou não elementos iguais no vetor.
'''
def main():
	numeros = [int(i) for i in raw_input().split()]
	numero_iguais(numeros)

def numero_iguais(numeros):
	for numero in numeros:
		if numero.acount >= 2:
			print'possui numeros iguais'
		else:
			print'nao possui numeros iguais'

if __name__ == '__main__':
	main()
