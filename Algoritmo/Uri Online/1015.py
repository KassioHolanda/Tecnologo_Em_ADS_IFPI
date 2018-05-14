
from math import sqrt, pow
def main():
	x = [float(i) for i in raw_input().split()]
	y = [float(i) for i in raw_input().split()]

	distancia = sqrt(pow((x[0]-y[0]),2)+(pow((x[1]-y[1]),2)))
	print "%.4f" % distancia

if __name__ == '__main__':
    main()
    
'''   

 
from math import sqrt, pow
def quadrado_da_diferenca(valor1, valor2):
	diferenca = pow(valor1-valor2,2)
	return diferenca

def distancia():
	x = [float(i) for i in raw_input().split()]
	y = [float(i) for i in raw_input().split()]

	distancia = float(sqrt(quadrado_da_diferenca(pow((x[1],x[0]),2)) + quadrado_da_diferenca(pow((y[1],y[0]),2))))
	print "O valor da distancia eh: %.4f" %(distancia)

if __name__ == '__main__':
    distancia()
    
'''