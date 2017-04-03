#_*_ coding: utf-8 _*_
#7 - Leia 3 números, calcule e escreva a soma dos 2 primeiros e a diferença entre os 2 últimos.

num1 = float(input("digite o primeiro numero: "))
num2 = float(input("digite o segundo numero: "))
num3 = float(input("digite o terceiro numero: "))

soma1 = num1 + num2
diferenca1 = num2/num3

print ("a soma dos dois primeiros numero é %.2f e a diferença dos dois ultimos numeros é %.2f" % (soma1, diferenca1))
