#coding:utf-8
#trabalho montadoara
import os
from platform import system as sys

def inicializar_montadora():
    arquivo_montadora = open('montadora_BD.txt','r')
    linhas = arquivo_montadora.readlines()
    montadora = []
    for linha in linhas:
        montadora.append(eval(linha))
    arquivo_montadora.close()

    return montadora

def inicializar_veiculos():
    arquivo_veiculos = open('veiculos_BD.txt','r')
    linhas = arquivo_veiculos.readlines()
    veiculos = []
    for linha in linhas:
        veiculos.append(eval(linha))
    arquivo_veiculos.close()

    return veiculos

def main():
    banco_de_dados = inicializar_veiculos()
    montadora = inicializar_montadora()
    cls()
    print''
    print'SISTEMA DE MONITORAMENTO DE MONTADORAS E VEICULOS'
    print'           ===> MENU PRINCIPAL <==='
    funcionalidade = raw_input('1 - Menu da montadora\n2 - Menu de Veiculos\n3 - Sair\nRESPOSTA: ')
    if funcionalidade == '1':
        main_montadora(montadora, banco_de_dados)
    elif funcionalidade == '2':
        main_veiculos(banco_de_dados, montadora)
    elif funcionalidade == '3':
        terminar()
    else:
        print'Digite uma opcao'
        main()
    cls()

def main_montadora(montadora, banco_de_dados):
    cls()
    print''
    print'           ===> MENU MONTADORA <==='
    funcionalidade = raw_input('1 - Nova Montadora\n2 - Listar Montadora\n3 - Menu princiapl\n4 - importar\n5 - Sair\nRESPOSTA: ')
    if funcionalidade == '1':
        arquivo_montadora = open('montadora_BD.txt','w')
        montadora.append(cadastrar_montadora(banco_de_dados,montadora))
        for cadastro in montadora:
            arquivo_montadora.writelines(str(cadastro)+ '\n')
        arquivo_montadora.close()
        main_montadora(montadora, banco_de_dados)
    elif funcionalidade == '2':
        listar_montadora(montadora, banco_de_dados)
    elif funcionalidade == '3':
        main()
    elif funcionalidade == '4':
        importar(banco_de_dados, montadora)
        salvar_m(montadora)
        main()
    elif funcionalidade == '5':
        terminar()
    else:
        raw_input('Digite uma opcao valida do menu')
        cls()
        main_montadora(montadora, banco_de_dados)
    


def main_veiculos(banco_de_dados, montadora):  
    cls()
    print''
    print'           ===> MENU VEICULOS <==='
    print('Para cadastrar o veiculos verifique primeiro o ID da montadora')
    funcionalidade = raw_input('\n1 - Novo veiculo\n2 - Listar veiculos\n3 - Remover veiculos\n4 - Editar veiculos\n5 - Menu Principal\n6 - sair\nRESPOSTA: ')
    if funcionalidade == '1':
        arquivo_veiculos = open('veiculos_BD.txt','w')
        banco_de_dados.append(adicionar_veiculos(banco_de_dados, montadora))
        for cadastro in banco_de_dados:
            arquivo_veiculos.writelines(str(cadastro) + '\n')
        arquivo_veiculos.close()
        main_veiculos(banco_de_dados,montadora)

    elif funcionalidade == '2':
        listar_veiculos(banco_de_dados, montadora)
    elif funcionalidade == '3':
        remover_veiculos(banco_de_dados, montadora)
    elif funcionalidade == '4':
        editar_veiculos(banco_de_dados, montadora)
    elif funcionalidade == '5':
        main()
    elif funcionalidade == '6':
        terminar()
    else:
        raw_input('Digite uma opção valida')
        cls()
        main_veiculos(banco_de_dados, montadora) 
    cls()

def cadastrar_montadora(banco_de_dados, montadora):
    cls()
    print''
    print'           ===> CADASTRO MONTADORA <==='
    nome = raw_input('Qual o nome da Montadora: ')
    pais = raw_input('Qual o pais de origem: ')
    ID = len(montadora) + 1
    novo_cadastro =  {'Nome': nome.title(), 'Pais': pais.title(), 'ID': ID}
    raw_input ('A montadora foi Salva no Banco de dados')
    return novo_cadastro
    
def listar_montadora(montadora, banco_de_dados):
    cls()
    print''
    print'           ===> LISTAGEM DE MONTADORA <==='
    deseja_listar = raw_input('Filtrar os dados da lista?(1 - SIM, 2 - NAO, 3 - menu): ')
    if deseja_listar == '2':
        for cadastro in montadora:
            print'|ID: %s | Nome: %s   | Pais de Origem: %s|' % (cadastro['ID'],cadastro['Nome'], cadastro['Pais'])
        raw_input('')
        cls()
    elif deseja_listar == '3':
        main()
    elif deseja_listar == '1':
        filtrar = raw_input('1 - por nome\n2 - por quantidade de veiculos\n3 - voltar')
        if filtrar == '1':
            nome_filtrar = raw_input('qual o nome da Montadora: ')
            for mont in montadora:
                if nome_filtrar.title() == mont['Nome']:
                    print'|ID: %s | Nome: %s   | Pais de Origem: %s|' % (mont['ID'], mont['Nome'], mont['Pais'])
            else:
                raw_input('FIM')    
                listar_montadora(montadora, banco_de_dados)
            main_montadora(montadora, banco_de_dados)

        elif filtrar == '2':
            contador = 0
            nome_filtrar = raw_input('Digite o Nome da Montadora: ')
            for cadastro_montadora in banco_de_dados:
                if cadastro_montadora['Montadora'] == nome_filtrar.title():
                    print'|ID: %d   | Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro_montadora['ID'], cadastro_montadora['Nome'], cadastro_montadora['Valor'], cadastro_montadora['Ano'], cadastro_montadora['Motor'], cadastro_montadora['Montadora'])
                    contador += 1
            print 'Nome: %s   | Numero de veiculos: %d' % (nome_filtrar.title(), contador)

        elif filtrar == '3':
            main_montadora(montadora, banco_de_dados)
        else:
            raw_input('digito invalido')
            listar_montadora(montadora, banco_de_dados)

    else:
        raw_input('DIGITE OPÇÃO DO MENU')
        cls()
        listar_montadora(montadora, banco_de_dados)
    raw_input('voltando ao menu')
    main_montadora(montadora, banco_de_dados)

def adicionar_veiculos(banco_de_dados, montadora):
    cls()
    print''
    print'           ===> ADICIONAR VEICULOS <==='
    for cadastro in montadora:
        print'ID: %s | Nome: %s   | Pais de Origem: %s' % (cadastro['ID'],cadastro['Nome'], cadastro['Pais'])
    print''
    id_montadora = input('Qual o ID da montadora relacionado ao veiculo(acesse o menu montadora): ')
    for cadastro_montadora in montadora:
        if id_montadora == cadastro_montadora['ID']:
            for montadora_veiculos in montadora:
                if montadora_veiculos['ID'] == id_montadora:
                    nome_da_montadora = montadora_veiculos['Nome']
                    nome = raw_input('Qual o nome do veiculos: ')
                    valor = float(input('Qual o valor do veiculo: '))
                    ano = input('Qual o ano do veiculo: ')
                    motor = float(input('Qual a força do motor: '))
    print'---------------------------------------------'
    indice = len(banco_de_dados) + 1
    novo_cadastro = {'Nome': nome.title(), 'Valor': float(valor), 'Ano': ano, 'ID': indice, 'Motor': float(motor),'Montadora': nome_da_montadora.title()}
    raw_input('O veiculo foi savo')
    return novo_cadastro

def listar_veiculos(banco_de_dados, montadora):
    print''
    print'           ===> LISTAR VEICULOS <==='
    deseja_filtrar = raw_input('filtrar lista?(1 - SIM, 2 - NAO, 3 - MENU): ')
    if deseja_filtrar == '2':
        for cadastro in banco_de_dados: 
            print'|ID: %d | Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro['ID'], cadastro['Nome'], cadastro['Valor'], cadastro['Ano'], cadastro['Motor'], cadastro['Montadora'])
        raw_input('listagem')
        cls()
        main_veiculos(banco_de_dados, montadora)
        
    elif deseja_filtrar == '1':
        filtrar = raw_input('1 - Por nome\n2 - Por Montadora\n3 - Por ano\n4 - Por faixa de preco\n5 - Por motor e faixa de preco\n6 - Para voltar\nRESPOSTA: ')
        if filtrar == '1':
            nome_filtrar = raw_input('Digite o Nome: ')
            for cadastro_nome in banco_de_dados:
                if cadastro_nome['Nome'] == nome_filtrar.title():
                    print'|ID: %d | Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro_nome['ID'], cadastro_nome['Nome'], cadastro_nome['Valor'], cadastro_nome['Ano'], cadastro_nome['Motor'], cadastro_nome['Montadora'])
            raw_input('listagem')
            cls()
            listar_veiculos(banco_de_dados, montadora)
            
        elif filtrar == '2':
            nome_filtrar = raw_input('Digite o Nome da Montadora: ')
            for cadastro_montadora in banco_de_dados:
                if cadastro_montadora['ID Montadora'] == nome_filtrar.title():
                    print'|ID: %d| Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro_montadora['ID'], cadastro_montadora['Nome'], cadastro_montadora['Valor'], cadastro_montadora['Ano'], cadastro_montadora['Motor'], cadastro_montadora['Montadora'])
            raw_input('listagem')
            cls()
            listar_veiculos(banco_de_dados, montadora)
            
        elif filtrar == '3':
            nome_filtrar = [int(i) for i in raw_input('Digite o Ano (para pesquisar entre anos:(exemplo: 2010 2015) : ').split()]
            if len(nome_filtrar) == 1:
                for cadastro_ano in banco_de_dados:
                    if cadastro_ano['Ano'] == nome_filtrar:
                        print'|ID: %d | Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro_ano['ID'], cadastro_ano['Nome'], cadastro_ano['Valor'], cadastro_ano['Ano'], cadastro_ano['Motor'], cadastro_ano['Montadora'])
                raw_input('listagem')
                cls()
                listar_veiculos(banco_de_dados, montadora)
                
            else:
                for cadastro_ano in banco_de_dados:
                    if cadastro_ano['Ano'] > nome_filtrar[0] and cadastro_ano['Ano'] < nome_filtrar[1]:
                        print'|ID: %d | Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro_ano['ID'], cadastro_ano['Nome'], cadastro_ano['Valor'], cadastro_ano['Ano'], cadastro_ano['Motor'], cadastro_ano['Montadora'])
                raw_input('listagem')
                cls()
                listar_veiculos(banco_de_dados, montadora)
                   
        elif filtrar == '4':
            nome_filtrar = [float(i) for i in raw_input('Digite o valor,(para pesquisar entre valores:(exemplo: 40,000 45,000) : ').split()]
            if len(nome_filtrar) == 1:
                for cadastro_valor in banco_de_dados:
                    if cadastro_valor['Valor'] == nome_filtrar:
                        print'|ID: %d | Nome: %s   | Valor: %.2f   | Ano: %s   | Motor: %s   | Montadora: %s|' % (cadastro_valor['ID'], cadastro_valor['Nome'], cadastro_valor['Valor'], cadastro_valor['Ano'], cadastro_valor['Motor'], cadastro_valor['Montadora'])
                raw_input('listagem')
                cls()
                listar_veiculos(banco_de_dados, montadora)
                
            else:
                for cadastro_valor in banco_de_dados:
                    if cadastro_valor['Valor'] > nome_filtrar[0] and cadastro_valor['Valor'] < nome_filtrar[1]:
                        print'|ID: %d | Nome: %s | Valor: %.2f | Ano: %s | Motor: %s | Montadora: %s|' % (cadastro_valor['ID'], cadastro_valor['Nome'], cadastro_valor['Valor'], cadastro_valor['Ano'], cadastro_valor['Motor'], cadastro_valor['Montadora'])
                raw_input('listagem')
                cls()
                listar_veiculos(banco_de_dados, montadora)
        
        elif filtrar == '5':
            valor_inicial = float(input('digite um valor incial: '))
            valor_final = float(input('digite um valor final: '))
            motor = float(input(('digite a motorização: ')))
            for cadastro_5 in banco_de_dados:
                if motor == cadastro_5['Motor']:
                    if valor_inicial <= cadastro_5['Valor'] and valor_final >= cadastro_5['Valor']:
                            print'|ID: %d | Nome: %s | Valor: %.2f | Ano: %s | Motor: %s | Montadora: %s|' % (cadastro_5['ID'], cadastro_5['Nome'], cadastro_5['Valor'], cadastro_5['Ano'], cadastro_5['Motor'], cadastro_5['Montadora'])
            raw_input('listagem')
            main()
        elif filtrar == '6':
            main()
    elif deseja_filtrar == '3':
        main_veiculos(banco_de_dados, montadora)

def remover_veiculos(banco_de_dados, montadora):
    print 'lista de veiculos'
    print''
    for cadastro in banco_de_dados: 
        print'|ID: %d | Nome: %s | Valor: %.2f | Ano: %s | Motor: %s | Montadora: %s|' % (cadastro['ID'], cadastro['Nome'], cadastro['Valor'], cadastro['Ano'], cadastro['Motor'], cadastro['Montadora'])
    print''
    print''
    indice = input('Qual o ID do veiculo para remover\nRESPOSTA: ')
    del banco_de_dados[indice - 1]
    salvar_b(banco_de_dados)
    main_veiculos(banco_de_dados, montadora)        
    
def editar_veiculos(banco_de_dados, montadora):
    for cadastro in banco_de_dados: 
        print'|ID: %d | Nome: %s | Valor: %.2f | Ano: %s | Motor: %s | Montadora: %s|' % (cadastro['ID'], cadastro['Nome'], cadastro['Valor'], cadastro['Ano'], cadastro['Motor'], cadastro['Montadora'])
    editar_veiculos = input('Digite a ID do veiculo para editar: ')
    for editar_veiculos_bd in banco_de_dados:
        if editar_veiculos == editar_veiculos_bd['ID']:
            editar_veiculos_bd['Nome'] = raw_input('digite o nome do veiculo: ')
            editar_veiculos_bd['Valor'] = float(input('digite o preço: '))
            editar_veiculos_bd['Ano'] = input('Qual o ano do veiculo: ')
            editar_veiculos_bd['Motor'] = float(input('qual a força do motor: '))
            raw_input('Alterado com sucesso')
            salvar_b(banco_de_dados)
    main_veiculos(banco_de_dados, montadora)

def importar(banco_de_dados, montadora):
    novo = []
    print 'Coloque o arquivo no diretorio.\nDigite o nome do arquivo seguindo de sua extensao. Ex: "arquivo.txt"'
    nome_arquivo = raw_input('Agora digite o nome do arquivo para ser importado: ')
    arquivo = open(str(nome_arquivo),'r')
    linhas = arquivo.readlines()
    for linha in linhas:
        novo.append(eval(linha))
    arquivo.close()
    for i in novo:
        montadora.append(i)
    cls()    

def salvar_b(banco_de_dados):
    arquivo_veiculos = open('veiculos_BD.txt', 'w')
    for cadastro in banco_de_dados:
        arquivo_veiculos.writelines(str(cadastro) + '\n')
    arquivo_veiculos.close()
    
def salvar_m(montadora):
    arquivo_montadora = open('montadora_BD.txt','w')
    for cadastro in montadora:
        arquivo_montadora.writelines(str(cadastro)+ '\n')
    arquivo_montadora.close()
        
def cls():
    if sys() == 'Linux':
        os.system('clear')
    if sys() == 'Windows':
        os.system('cls')

def terminar():
    print'===> FIM <==='
    quit()

if __name__ == '__main__':
    main()
