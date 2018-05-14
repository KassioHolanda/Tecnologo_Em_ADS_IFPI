#-*- coding: utf-8 -*-

"""
Escreva um algoritmo que, tendo como dados de entrada 2 pontos quaisquer no plano, ponto1 (x1,y1) e
ponto2 (x2,y2), escreva a distância entre eles, conforme fórmula abaixo.
"""


from math import sqrt, pow

x1 = input('digite um valor para x1: ')
x2 = input('digite um valor para x2: ')
y1 = input('digite um valor para y1: ')
y2 = input('digite um valor para y2: ')

distancia = sqrt(pow((x2-x1),2) + pow((y2-y1),2))

print ' a distancia entre os pontos é de %.2f' % distancia
