#-*- coding: utf-8 -*-

"""Leia um número N, calcule e escreva os N primeiros termos de seqüência de Fibonacci (0,1,1,2,3,5,8,...).
O valor lido para N sempre será maior ou igual a 2. """


def sequencia(n):
    n1 = 0
    n2 = 1
    print n1,n2,
    for i in range(n - 2):
        atual = n1 + n2
        n1= n2
        n2 = atual
        print atual,


def main():
    n = input("digite um numeo de limite: ")
    sequencia(n)

if __name__ == "__main__":
    main()
