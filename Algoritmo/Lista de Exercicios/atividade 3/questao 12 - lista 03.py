# -*- coding: utf-8 -*-

#Leia N e uma lista de N números e escreva a soma e a média de todos os números da lista.

def numeros(contador,numero):
    for num in range(1, numero + 1):
        resultado = contador + num
        contador += resultado


def main():
    numero = input("digite um numero: ")
    numeros(0,numero)

if __name__ == "__main__":
    main()

