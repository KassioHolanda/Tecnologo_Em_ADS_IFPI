#-*- coding: utf-8 -*-

def numero():
    for i in range(11, 0, -1):
        print('Número: %d' % i)
        divisores(i)



def divisores(valor):
    numero = valor
    for item in range(1,11):
        if numero % item == 0:
            print('Dividores: %d' % item)


if __name__ == '__main__':
    numero()