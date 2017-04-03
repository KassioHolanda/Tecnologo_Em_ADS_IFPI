#coding:utf-8
#trabalho montadoara
import os
from platform import system as sys

def inicializar_medalhas():
    arquivo_medalhas = open('medalhas_BD.txt','r')
    linhas = arquivo_medalhas.readlines()
    medalhas = []
    for linha in linhas:
        medalhas.append(eval(linha))
    arquivo_medalhas.close()

    return medalhas

def inicializar_paises():
    arquivo_paises = open('paises_BD.txt','r')
    linhas = arquivo_paises.readlines()
    paises = []
    for linha in linhas:
        paises.append(eval(linha))
    arquivo_paises.close()

    return paises

def main():
    banco_de_dados = inicializar_medalhas()
    paises = inicializar_paises()
  
    print'qual menu voce deseja entrar'
    menu = raw_input('1 - Menu de Medalhas\n2 - Menu de consultas e pesquisas\n3 - Importar Dados\n4 - listar paises\n5 - Sair\nRESPOSTA: ')
    if menu == '4':
        terminar()
    elif menu == '1':
        main_medalhas(banco_de_dados, paises)
    elif menu == '2':
        main_consultas(banco_de_dados, paises)
    elif menu == '3':
        importacao_dados(banco_de_dados, paises)
    elif menu == '4':
        listar_paises(banco_de_dados, paises)
        main()
    else:
        raw_input('opcao invalida')
        main()


def main_medalhas(banco_de_dados, paises):
    funcionalidade = raw_input('1 - Adicionar\n2 - Listar\n3 - Remover\n4 - voltar\n5 - sair\nRESPOSTA: ')
    if funcionalidade == '1':
        arquivo_medalhas = open('medalhas_BD.txt', 'w')
        banco_de_dados.append(cadastro_medalhas(banco_de_dados, paises))
        for cadastro in banco_de_dados:
            arquivo_medalhas.writelines(str(cadastro) + '\n')
        arquivo_medalhas.close()
        main()
    elif funcionalidade == '2':
        listar_medalhas(banco_de_dados, paises)
    elif funcionalidade == '3':
        remove(banco_de_dados, paises)
    elif funcionalidade == '4':
        main()
    elif funcionalidade == '5':
        terminar()
    else:
        raw_input('digite uma opcao do menu')
        main()


def main_consultas(banco_de_dados, paises):
    cls()
    contador = 0
    raw_input('Menu de pesquisas e consultas, ENTER para continuar ')
    menu = raw_input('0 - listar paises\n1 - tabela de medalhas por cada pais\n2 - quantidade de medalhas por continente\n3 - paises que nao ganharam medalhas\n4 - quantidade de medalhas por modalidade(masculino ou feminino)\n5 - paises com maior quantidade de medalhas por atleta e por habitante\n6 - por nome do atleta, mostrando suas medalhas\n7 - voltar\n8 - sair\nRESPOSTA: ')
    if menu == '8':
        terminar()
    elif menu == '0':
        listar_paises(banco_de_dados, paises)
    elif menu == '7':
        main()
    elif menu == '1':
        medalhas_pais(banco_de_dados, paises)
    elif menu == '2':
        medalhas_continente(banco_de_dados, paises)
    elif menu == '3':
        print'em construcao'

def medalhas_continente(banco_de_dados, paises):
    contador = 0
    print''
    for cadastro in banco_de_dados:
        print'ID: %s - Nome do Atleta: %s - Esporte: %s - Modalidade: %s - Medalha: %s - Pais do Atleta: %s' % (cadastro['ID'], cadastro['Nome do Atleta'],cadastro['Esporte'], cadastro['Modalidade'], cadastro['Medalha'], cadastro['Pais do Atleta'])
    print''
    print'tabela de medalhas por continente'
    continente = raw_input('qual o nome do continente: ')
    for cadastro in banco_de_dados:
        if cadastro['Pais do Atleta'] == continente.upper():
            contador += 1
    print 'Continente: %s   | Numero de medalhas: %d' % (continente.upper(), contador)
    raw_input('enter')
    main()


def importacao_dados(banco_de_dados, paises):
    novo = []
    print 'Coloque o arquivo no diretorio.\nDigite o nome do arquivo seguindo de sua extensao. Ex: "arquivo.txt"'
    nome_arquivo = raw_input('Agora digite o nome do arquivo para ser importado: ')
    arquivo = open(str(nome_arquivo),'r')
    linhas = arquivo.readlines()
    for linha in linhas:
        novo.append(linha.split('-'))
    arquivo.close()
    for i in novo:
        paises.append(i)


def medalhas_pais(banco_de_dados, paises):
    contador = 0
    print'tabela de medalhas por pais'
    pais = raw_input('qual o nome do pais: ')
    for cadastro in banco_de_dados:
        if cadastro['Pais do Atleta'] == pais.upper():
            contador += 1
    print 'Pais: %s   | Numero de medalhas: %d' % (pais.upper(), contador)
    raw_input('enter')
    main()


def cadastro_medalhas(banco_de_dados, paises):
    #cls()
    for cadastro in paises:
        print 'Nome Do Pais: %s - Continente: %s - Populacao: %s - Quantidade de Atletas: %s' % (cadastro['Nome Do Pais'], cadastro['Continente'], cadastro['Populacao'], cadastro['Atletas'])
    nome_pais = raw_input('Qual o nome do paises: ')
    for cadastro in paises:
        if cadastro['Nome Do Pais'] == nome_pais.title():
            nome_atleta = raw_input('nome do atleta: ')
            esporte = raw_input('qual o esporte: ')
            modalidade = raw_input('qual a modalidade do esporte(Masculino, Feminino, Misto): ')
            if modalidade.lower() != 'masculino' and modalidade.lower() != 'feminino' and modalidade.lower() != 'misto':
                raw_input('modalidade invalida')
                main_medalhas(banco_de_dados, paises)
            medalha_obtida = raw_input('qual medalha obtida(Ouro, Prata ou Bronze): ')
            if medalha_obtida.lower() != 'ouro' and medalha_obtida.lower() != 'prata' and medalha_obtida.lower() != 'bronze':
                raw_input('medalha invalida')
                main_medalhas(banco_de_dados, paises)
            cont = 0
            for i in banco_de_dados:
                cont+=1
            ID = cont + 1
            novo_cadastro = {'Nome do Atleta': nome_atleta.upper(), 'Esporte': esporte.upper(), 'Modalidade': modalidade.upper(), 'Medalha': medalha_obtida.upper(), 'Pais do Atleta': nome_pais.upper(), 'ID': ID}
            raw_input('Atleta cadastrado')
            cls()
            return novo_cadastro
        else:
            print'O pais nao existe, voltar e cadastrar'
            main()


def listar_medalhas(banco_de_dados,paises):
    for cadastro in banco_de_dados:
        print'ID: %s - Nome do Atleta: %s - Esporte: %s - Modalidade: %s - Medalha: %s - Pais do Atleta: %s' % (cadastro['ID'], cadastro['Nome do Atleta'],cadastro['Esporte'], cadastro['Modalidade'], cadastro['Medalha'], cadastro['Pais do Atleta'])
    raw_input('fim da listagem')
    cls()
    main_medalhas(banco_de_dados, paises)


def listar_paises(banco_de_dados, paises):
    for cadastro in paises:
        print 'Nome Do Pais: %s - Continente: %s - Populacao: %s - Quantidade de Atletas: %s' % (cadastro['Nome Do Pais'], cadastro['Continente'], cadastro['Populacao'], cadastro['Atletas'])
    main()
        

def remove(banco_de_dados, paises):
    print''
    for cadastro in banco_de_dados:
        print'ID: %s - Nome do Atleta: %s - Esporte: %s - Modalidade: %s - Medalha: %s - Pais do Atleta: %s' % (cadastro['ID'], cadastro['Nome do Atleta'],cadastro['Esporte'], cadastro['Modalidade'], cadastro['Medalha'], cadastro['Pais do Atleta'])
    print''
    indice = input('Qual o ID do cadastro para remover\nRESPOSTA: ')
    del banco_de_dados[indice - 1]
    raw_input('cadastro removido')
    cls()
    salvar_medalhas(banco_de_dados, paises)
    main()


def salvar_medalhas(banco_de_dados, paises):
    arquivo_dados = open('medalhas_BD.txt', 'w')
    banco_de_dados.append(cadastro_medalhas(banco_de_dados, paises))
    for cadastro in banco_de_dados:
        arquivo_dados.writelines(str(cadastro) + '\n')
    arquivo_dados.close()

def cls():
    if sys() == 'Linux':
        os.system('clear')
    if sys() == 'Windows':
        os.system('cls')


def terminar():
    raw_input('fim')
    quit()


if __name__ == '__main__':
    main()
