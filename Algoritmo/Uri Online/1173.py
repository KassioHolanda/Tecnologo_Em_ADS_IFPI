# -*- coding: utf-8 -*-

def main():
    numero = input()
    lista = []

    for i in range(10):
        lista.append(numero)
        numero = numero * 2

    for i in range(10):
        print 'N[%d] = %d' % (i, lista[i])

if __name__=='__main__':
    main()
