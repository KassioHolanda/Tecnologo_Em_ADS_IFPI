#_*_ coding: utf-8 _*_
#10 - Leia 2 números inteiros, calcule e escreva o quociente e o resto da divisão do 1o pelo 2o.

num1 = float(input("digite o primeiro numero: "))
num2 = float(input("digite o segundo numero: "))

quociente =  num1 / num2
resto = num1%num2

print ("o quociente e o resto da divisao dos numeros sao respctivamente: %.2f e %.2f" % (quociente,resto))
