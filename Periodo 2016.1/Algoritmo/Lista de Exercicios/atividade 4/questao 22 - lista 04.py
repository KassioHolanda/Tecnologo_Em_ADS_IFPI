# -*- coding: utf-8 -*-

"""Leia 2 números inteiros e escreva o quociente e o resto da divisão dos mesmos,
sem que os operadores de divisão (/ e %) sejam utilizados"""

valor1 = float(input("informe o valor um: "))
valor2 = float(input("informe o valor dois: "))

resul = 0
while valor2 >= 1:
    resul = valor1 - 1
    valor2 -= 1

print resul
