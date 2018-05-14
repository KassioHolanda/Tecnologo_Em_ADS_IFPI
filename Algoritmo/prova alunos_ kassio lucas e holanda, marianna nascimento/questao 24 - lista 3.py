#-*- coding: utf-8 -*-
"""
24. A prefeitura de uma cidade fez uma pesquisa entre seus habitantes, coletando dados sobre o salário e
número de filhos. Escreva um algoritmo que leia o salário e o número de filhos de N habitantes e
escreva:
a) média de salário da população;
b) média de número de filhos;
c) percentual de pessoas com salário de até R$ 1.000,00.
"""
def main():
    sal = 0
    num_f = 0
    pessoas = 0
    n_sal = 0.0
    p_sal = 0
    print'para cancelar o questionamento digite (0) duas vezes'
    salario = input('digite o seu salario: ')
    filhos = input('digite quantos filhos voce tem: ')
    print'-----------------------------------------------------------'

    while salario != 0:
        if salario >= 1000:
            n_sal += 1
        sal = salario + sal
        num_f = filhos + num_f
        print'para cancelar o questionamento digite (0)'
        salario = input('digite o seu salario: ')
        filhos = input('digite quantos filhos voce tem: ')
        print'------------------------------------------------------------'
        pessoas += 1

    questionario(sal, num_f, n_sal, p_sal, pessoas)

def questionario(sal, num_f, n_sal, p_sal, pessoas):
    print'------------------------------------------------------------'
    print'------------------------------------------------------------'
    print'a media salarial da populaçoã é de %d R$' % (sal/pessoas)
    print'a media de filhos da produação é de %d' % (num_f/pessoas)
    print'a porcentual de pessoas que recebem um salario acima de 1000 reais é de %.1f %%' % ((n_sal/pessoas)*100)

if __name__ == '__main__':
    main()