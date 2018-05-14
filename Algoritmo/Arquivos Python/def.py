import math
from math import s

def quadrado_da_diferenca(valor1, valor2):
	diferenca = pow(valor1-valor2,2)
	return diferenca

def distancia():
	x1 = float(input('X1: '))
	y1 = float(input('Y1: '))
	x2 = float(input('X2: '))
	y2 = float(input('Y2: '))

	distancia = sqrt(quadrado_da_diferenca(x2,x1) + quadrado_da_diferenca(y2, y1))
	print "O valor da distancia eh: %.4f" %(distancia)


if __name__ == '__main__':
	distancia()
