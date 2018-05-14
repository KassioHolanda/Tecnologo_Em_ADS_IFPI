#-*- coding: utf-8 -*-

#Leia  dois  números  X  e  N.  A  seguir, escreva o  resultado  das  divisões  de  X  por  N  onde,  após  cada
#divisão, X passa a ter como conteúdo o resultado da divisão anterior e N é decrementado de 1 em 1, até
#chegar a 2.

x = float(input("digite um numero para X: "))
n = float(input("digite um numero para N"))
while n >= 2:
    resultado = float(x / n)
    x = resultado
    n = n - 1
    print "o resultado da divisao sera de %.8f" % resultado

