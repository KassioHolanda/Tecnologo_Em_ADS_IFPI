#-*- coding: utf-8 -*-
"""
Leia o salário de funcionários de uma empresa, calcule e escreva o novo salário (segundo os critérios
descritos abaixo), a soma dos salários atuais, a soma dos salários reajustados e a diferença entre as 2
somas. (Flag: salário=0)


"""

def main():
    salario_i = float(input('digite o salario do funcioario da empresa: '))
    salarios(salario_i)


def salarios(salario_i):
    n_func = 0
    t_sal = 0
    n_sal = 0
    t_n_sal = 0

    while salario_i != 0:
        n_func += 1
        t_sal = salario_i + t_sal




        n_sal25 = float((salario_i * 0.25) + salario_i)
        n_sal20 = float((salario_i * 0.20) + salario_i)
        n_sal15 = float((salario_i * 0.15) + salario_i)
        n_sal10 = float((salario_i * 0.10) + salario_i)

        if salario_i < 3000:
            n_sal = n_sal25
        if salario_i >= 3000:
            if salario_i < 6000:
                n_sal = n_sal20
        if salario_i >= 6000:
            if salario_i < 10000:
                n_sal = n_sal15
        if salario_i >= 10000:
            n_sal = n_sal10

        t_n_sal += n_sal

        salario_i = float(input('digite o salario de outro funcioario da empresa: '))

    print'a soma de todos os salarios inciais é de %.2f' % t_sal
    print'a soma de todos os salarios reajustados é de %.2f' % t_n_sal
    print'a diferença dos salarios reajustados e inicial é de %.2f' % (t_n_sal - t_sal)











if __name__=='__main__':
    main()