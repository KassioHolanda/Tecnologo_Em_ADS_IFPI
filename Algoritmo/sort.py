#coding:utf-8
import random

def main():
	menu = raw_input('1 - bubble_sort\n2 - selection_sort\n3 - insert_sort\n4 - binario')
	if menu == '1':
		bubble_sort()
	elif menu == '2':
		selection_sort()
	elif menu ='3':
		insert_sort()
	elif menu = '4':
		binario()

def bubble_sort():
	vetor = [int(i) for i in raw_input().split()]
	if len(vetor) <= 1:
		print vetor
	else:
		for i in range(0, len(vetor)):
			for j in range(0, len(vetor)-1-i):
				if vetor[j]>vetor[j+1]:
					vetor_n = vetor[j+1]
					vetor[j+1] = vetor[j]
					vetor[j] = vetor_n
		print vetor
	
def selection_sort():
	vetor = [int(i) for i in raw_input().split()]
	for i in range(len(vetor)-1,0,-1):
		maior_numero = 0
		for j in range(1, len(vetor)):
			if vetor[j]>vetor[maior_numero]:
				maior_numero = j
		vetor_n = vetor[i]
		vetor[i] = vetor[maior_numero]
		vetor[maior_numero] = vetor_n


def insert_sort():
	vetor = [int(i) for i in raw_input().split()]
	for i in range(1, len(vetor)):
		valor = vetor[i]
		posicao = i
		while posicao>0 and vetor[posicao-1]>valor:
			vetor[posicao] = vetor[posicao-1]
			posicao = posicao-1
		vetor[posicao] = valor
	print vetor

def binario():
    lista = []
    N = input('quantidade de numeros: ')
    for i in range (N):
        lista.append(i)
    valor = input('Informe um numero: ')
    inicio = min(lista)
    fim = max(lista)
    meio = (fim / 2)
    binario_calculo(valor, inicio, meio, fim)

def binario_calculo(valor, inicio, meio, fim):
    if valor == meio:
        print('o numero digitado e: %d' % valor)
        quit()
    elif fim > valor > meio:
        inicio = meio
        meio = ((fim+inicio) / 2)
        fim = fim
        valor = valor
        print(inicio, meio, fim)
        binario(valor, inicio, meio, fim)
    elif meio > valor > inicio:
        fim = meio
        meio = ((fim+inicio) / 2)
        inicio = inicio
        valor = valor
        print(inicio, meio, fim)
        binario(valor, inicio, meio, fim)

if __name__ == '__main__':
	main()