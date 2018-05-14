#-*- coding: utf-8 -*-

'''
 Escreva uma sub-rotina que gere logins para usuários de um sistema de computação baseado na seguinte regra: 
 o login é composto pelas letras iniciais do nome do usuário. 
 '''

def main():
        print 'digite (s) para sair'
        nome = raw_input('digite seu nome completo para gerar o login: ')
        if nome == 's':
                print'fim'
        part = ''
        for nomes in nome.split():
                part = part + nome[0] + nomes[1]
                print part
        main()


def senha(nome):
        num = str(rand(100,1000))
        print nome + num
        main()




        



if __name__ == '__main__':
       main()
