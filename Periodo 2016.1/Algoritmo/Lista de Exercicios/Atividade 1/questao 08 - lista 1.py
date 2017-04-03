#_*_ coding: utf-8 _*_
#8 - Leia 2 números, calcule e escreva a divisão da soma pela subtração dos números lidos.

num1 = float(input("digite o primeiro número: "))
num2 = float (input("dgite o segundo numero: "))


soma = float(num1+num2)
subtracao = float(num1 - num2)
divisao= float(soma/subtracao)

print ("a soma dos numeros e %d, a subtração dos numero é %d, sendo que a divisao da soma pela subtração é %d" % (soma, subtracao, divisao))
