#coding:utf-8

'''
Leia 2 vetores A e B com N elementos, escreva um vetor C, sendo este a junção dos vetores A e B. 
Desta forma, o vetor C deverá ter 2*N elementos.
'''

def main():
	quantidade_A = input('digite a quantidade de numeros do vetor A: ')
	vetor_A = range(quantidade_A)
	quantidade_B = input('digite a quantidade de numeros do vetor B: ')
	vetor_B = range(quantidade_B)
	novo_vetor(vetor_A, vetor_B)

def novo_vetor(vetor_A,vetor_B):
	vetor_C = vetor_A + vetor_B
	print vetor_C

if __name__ == '__main__':
	main()
