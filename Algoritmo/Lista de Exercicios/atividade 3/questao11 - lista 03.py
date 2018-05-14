#-*- coding: utf-8 -*-

# Leia LimiteSuperior e LimiteInferior e escreva todos os números primos entre os limites lidos.
def main():
    limitesuperior = input("digite um numero para limite superior (max 1000): ")
    limiteinferior = input("digite um numero para limite inferior (min 2): ")
    primos(limiteinferior,limitesuperior)


def primos(limite_inf,limite_superior):
    for numero in range(limite_inf,limite_superior+1):
        if verifica_primos(numero) == numero:
            print numero


def verifica_primos(num):
    if num == 2 or num == 3 or num == 5 or num == 7 or num == 11 or num == 13 or num == 17 or num == 19:
        return num
    elif num !=0:
        if num%2 !=0 and num%3 !=0 and num%5 !=0 and num !=0 and num%11  != 0 and num%13 != 0 and num%17 != 0 and num%19 != 0:
            return num

if __name__=="__main__":
    main()