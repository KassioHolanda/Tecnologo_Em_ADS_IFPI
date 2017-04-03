#-*- coding: utf-8 -*-
"""
Leia um número N, calcule e escreva os N primeiros termos de seqüência de Fibonacci
(0,1,1,2,3,5,8,...). O valor lido para N sempre será maior ou igual a 2.

"""

def main():
    num2 = input('digite um numero para n: ')
    sequencia(0,1, num2, 0)


def sequencia(num, num1, num2, num3):
    while num1 <= num2:
        num = 0
        num1 = 1
        print num, num1,
        num3 = num + num1
        num = num1
        sequencia(num, num1, num2, num3)



if __name__ == "__main__":
    main()


"""
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
"""