#-*- coding: utf-8 -*-

"""
Para o cálculo de uma folha de pagamento, sabendo que os descontos são do Imposto de Renda, que
depende do salário bruto (conforme tabela abaixo) e 3% para o Sindicato e que o FGTS corresponde a
11% do salário bruto, mas não é descontado (é a empresa que deposita). O salário líquido corresponde
ao salário bruto menos os descontos. O programa deverá pedir ao usuário o valor da sua hora e a
quantidade de horas trabalhadas no mês.
Desconto do IR:
o Salário Bruto até R$ 900,00 (inclusive) - isento
o Salário Bruto até R$ 1.500,00 (inclusive) - desconto de 5%
o Salário Bruto até R$ 2.500,00 (inclusive) - desconto de 10%
o Salário Bruto acima de R$ 2.500,00 - desconto de 20%
Escreva na tela as informações, dispostas conforme o exemplo abaixo. No exemplo o valor da hora é 5 e
a quantidade de hora é 220.
Salário Bruto: (5 * 220)
: R$ 1100,00
(-) IR (5%)
: R$ 55,00
(-) INSS ( 10%)
: R$ 110,00
FGTS (11%)
: R$ 121,00
Total de descontos
: R$ 165,00
Salário Liquido
: R$ 935,00

"""


def main():
    valor_h = input('qual o valor da hora de trabalho: ')
    qnt_h = input('quantas horas no mes sao trabalhadas: ')
    trabalho(valor_h, qnt_h)


def trabalho(valor_h, qnt_h):
    salario = valor_h * qnt_h
    if salario < 900:
        n_salario = salario - (salario*0.10)
        print 'o salario com descontos sera de %.2f' % n_salario


if __name__=='__main__':
    main()