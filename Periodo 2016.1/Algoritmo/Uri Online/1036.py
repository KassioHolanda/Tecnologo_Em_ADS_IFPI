from math import sqrt, pow
def main():
	lista = [i for i in raw_input().split()]
	a = float(lista[0])
	b = float(lista[1])
	c = float(lista[2])
	
	delta = float(pow(b,2)+(4*a*c))
	x1 = float(-b + sqrt(delta))/(2*a)
	x2 = float(-b - sqrt(delta))/(2*a)
	if (x1 or x2 == 0) or sqrt(delta) < 0:
		print 'Impossivel calcular'
	else:
		print '%.5f\n%.5f' % (x1, x2)

if __name__ == '__main__':
	main()
