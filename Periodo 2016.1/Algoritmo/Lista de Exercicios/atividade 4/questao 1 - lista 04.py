#-*- coding: utf-8 -*-


#Leia uma lista de números e que para cada número lido, escreva o próprio número e a relação de seus
#divisores. (flag número = 0).


def divisores(num):
    for i in range(num, 1, -1):
        if num % i == 0:
            print i

def main():
    num = input("digite um numero: ")
    divisores(num)

if __name__ =="__main__":
    main()

