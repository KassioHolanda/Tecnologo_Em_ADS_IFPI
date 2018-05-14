#-*- coding: utf-8 -*-

'''
As companhias de transportes aéreos costumam representar os nomes dos passageiros no formato último sobrenome/nome.
Por exemplo, o passageiro Carlos Drummond de Andrade seria indicado por Andrade/Carlos. 
Escreva um programa que leia um nome completo e o escreva no formato acima. 
'''

def main():
        nome = raw_input('qual seu nome completo: ')
        for nomes in nome.split():
                nome_separado_1 = nomes[0:]
                nome_separado_2 = nomes[0:]
        print nome_separado_1, nome[0:nome_separado_1]



if __name__ == '__main__':
        main()
 
