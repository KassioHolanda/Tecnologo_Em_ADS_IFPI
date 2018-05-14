#-*- coding: utf-8 -*-

#Leia um verbo regular terminado em ER e mostre sua conjugação no presente


def main():
	frase = raw_input('digite uma frase terminada em (ER): ')
	print 'eu %s' % frase.replace('er', 'o')
	print 'tu %s' % frase.replace('r', '')
	print 'ele %s' % frase.replace('r', '') 
	print 'nos %s' % frase.replace('r', 'mos')
	print 'vos %s' % frase.replace('r', 'is')
	print 'eles %s' % frase.replace('r', 'm')


if __name__=='__main__':
        main()
