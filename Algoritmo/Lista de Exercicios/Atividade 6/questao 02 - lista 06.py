#-*- coding: utf-8 -*-

'''
Leia uma frase e mostre cada palavra da frase em uma linha separada
'''

def main():
        frase = raw_input('digite um frase: ')
        frases(frase)

def frases(frase):
        contador = 0
        while contador < len(frase):
                print frase[contador]
                contador = contador + 1


if __name__== '__main__':
        main()
