#coding:utf-8
"""
Escreva um programa que leia um valor inteiro N. Este N é a quantidade de linhas de saída que serão apresentadas na
execução do programa.
"""
def main():
    N = int(input())

    for i in range(1, (N * 4) + 1):
        if i % 4 == 0:
            print('PUM')
        else:
            print i,

if __name__ == '__main__':
    main()