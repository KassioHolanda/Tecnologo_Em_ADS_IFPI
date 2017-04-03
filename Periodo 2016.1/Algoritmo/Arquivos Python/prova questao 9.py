# -*- coding: utf-8 -*-


def multiplos(num, x)
:	if x > 10:
		print "fim"
	else:	
		multi = num * x
		print multi
		multiplos(num, x + 1)

def main():
	num =i nput("digite um numero: ")
	multiplos(num, 0)

if __name__ == '__main__':
	main()