# -*- coding: utf-8 -*-

#Escreva um algoritmo que leia a razão de uma PA (Progressão Aritmética) e o seu primeiro termo e escreva os N termos da PA.  Ler o valor de N.


primeiro  = input("escreva o primeiro termo: ")
razao = input("escreva a razao da PG: ")
n = input("escreva o numero para finalizar a PA: ")

while n > primeiro:
    valor_i = primeiro
    print primeiro,
    primeiro = primeiro + razao
