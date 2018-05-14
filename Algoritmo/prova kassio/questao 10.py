#-*- coding: utf-8 -*-

def quadrante(x,y):
	if (x < 0) and (y > 0):
		print "o ponto esta no segundo quadrante"
	elif (x < 0) and (y < 0):
		print "o ponto esta no terceiro quadrante" 
	elif (x > 0) and (y < 0):
		print "o ponto esta no quarto quadrante"
	elif (x > 0) and (y > 0):
		print"o ponto esta no primeiro quadrante"

def main():
	x = int(input("digite um numero para x: "))
	y = int(input("digite um numero para y: "))
	quadrante(x,y)

if __name__ == '__main__':
	main()