# -*- coding: utf-8 -*-
"""
--- RECEBE 2 NUMEROS E CALCULA O M.M.C.---
MMC = contador%numero1 == 0 and contador%numero2 == 0:
"""

numero1 = int(input('Digite o primeiro número: '))
numero2 = int(input('Digite o segundo número: '))
contador = numero1

while contador%numero1 != 0 or contador%numero2 != 0:
    contador += 1

""" MMC = contador%numero1 == 0 and contador%numero2 == 0:"""


print('O M.M.C. de %d e %d é: %d' % (numero1, numero2, contador))