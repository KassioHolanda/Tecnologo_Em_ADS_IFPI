#coding:utf-8
'''
Leia um valor inteiro, que é o tempo de duração em segundos de um determinado evento em uma fábrica, 
e informe-o expresso no formato horas:minutos:segundos.
Entrada

O arquivo de entrada contém um valor inteiro N.
Saída

Imprima o tempo lido no arquivo de entrada (segundos), convertido para horas:minutos:segundos, conforme exemplo fornecido.
'''
def main():
	valor = input()
	minutos = 0
	horas = 0
	while valor >= 60:
		minutos += 1
		valor -= 60
	while minutos >= 60:
		horas += 1
		minutos -= 60
	segundos = valor

	print '%d:%d:%d' % (horas, minutos, segundos)


if __name__ == '__main__':
	main()