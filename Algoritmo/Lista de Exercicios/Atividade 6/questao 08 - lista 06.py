#	 -*- coding: utf-8 -*-


#Leia uma string no formato hh:mm:ss e escreva o resultado na seguinte forma: “hh hora(s), mm minuto(s) e ss segundo(s)”.

def main():
	data = raw_input('que horas sao?(digite no formato hh:mm:ss): ')

	print 'sao %s horas, %s minutos e %s segundos' % (data[0:2], data[3:5], data[6:8])


if __name__ == '__main__':
	main()
