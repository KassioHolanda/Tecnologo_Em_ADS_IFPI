def inicializar():
    arquivo = open('BD.txt','r')
    linhas = arquivo.readlines()
    banco_de_dados = []
    for linha in linhas:
        banco_de_dados.append(eval(linha))
    arquivo.close()

    return banco_de_dados

def main():
    banco_de_dados = inicializar()
    funcionalidade = raw_input('1 - adicionar\n2 - remover\n3 - listar todos\n4 - menu de consultas\n5 - terminar\n')
    if funcionalidade == '1':
        arquivo = open('BD.txt','w')
        banco_de_dados.append(adicionar(banco_de_dados))
        for cadastro in banco_de_dados:
            arquivo.writelines(str(cadastro) + '\n')
        arquivo.close()
        main()
    elif funcionalidade == '2':
        remover(banco_de_dados)
    elif funcionalidade == '3':
        listar(banco_de_dados)
    elif funcionalidade == '4':
        consultas(banco_de_dados)
    elif funcionalidade == '5':
        terminar()
    else:
        print'Digite uma opcao'
        main()

def adicionar(banco_de_dados):
    nome = raw_input('nome candidato: ')
    numero = input('numero do candidato: ')
    sigla_partido = raw_input('sigla do partido: ')
    cargo = raw_input('cargo do candidato: ')
    sexo = raw_input('sexo do candidado(M|F): ')
    ID = len(banco_de_dados) + 1
    novo = {'ID': ID, 'Nome':nome.upper(), 'Numero': numero, 'Sigla do Partido': sigla_partido.upper(), 'Cargo': cargo.upper(), 'Sexo': sexo.upper()}
    return novo

def remover(banco_de_dados):
    for cadastro in banco_de_dados:
        print ('ID: %s, Nome: %s, Numero: %s, Sigla do Partido: %s, Cargo: %s, Sexo: %s') % (cadastro['ID'], cadastro['Nome'], cadastro['Numero'], cadastro['Sigla do Partido'], cadastro['Cargo'], cadastro['Sexo'])
    indice = input('Qual o ID do veiculo para remover\nRESPOSTA: ')
    del banco_de_dados[indice - 1]
    salvar(banco_de_dados)
    main()

def listar(banco_de_dados):
    for cadastro in banco_de_dados: 
        print ('ID: %s, Nome: %s, Numero: %s, Sigla do Partido: %s, Cargo: %s, Sexo: %s') % (cadastro['ID'], cadastro['Nome'], cadastro['Numero'], cadastro['Sigla do Partido'], cadastro['Cargo'], cadastro['Sexo'])
    raw_input('listagem')
    main()

def salvar(banco_de_dados):
    arquivo = open('BD.txt', 'w')
    for cadastro in banco_de_dados:
        arquivos.writelines(str(cadastro) + '\n')
    arquivo.close()

def consultas(banco_de_dados):
    for cadastro in banco_de_dados:
        print ('ID: %s, Nome: %s, Numero: %s, Sigla do Partido: %s, Cargo: %s, Sexo: %s') % (cadastro['ID'], cadastro['Nome'], cadastro['Numero'], cadastro['Sigla do Partido'], cadastro['Cargo'], cadastro['Sexo'])
    funcionalidade = raw_input('1 - buscar por nome\n2 - buscar por partido\n3 - buscar por quantidade e porcentagem por sexo\n4 - buscar por numero\n5 - voltar\n')
    if funcionalidade == '1':
        nome = raw_input('qual o nome do candidato: ')
        for cadastro in banco_de_dados:
            if cadastro['Nome'] == nome.upper():
                print ('ID: %s, Nome: %s, Numero: %s, Sigla do Partido: %s, Cargo: %s, Sexo: %s') % (cadastro['ID'], cadastro['Nome'], cadastro['Numero'], cadastro['Sigla do Partido'], cadastro['Cargo'], cadastro['Sexo'])
        raw_input()
        main()

    elif funcionalidade == '2':
        partido = raw_input('qual a sigla do candidato')
        for cadastro in banco_de_dados:
            if cadastro['Sigla do Partido'] == partido.upper():
                print ('ID: %s, Nome: %s, Numero: %s, Sigla do Partido: %s, Cargo: %s, Sexo: %s') % (cadastro['ID'], cadastro['Nome'], cadastro['Numero'], cadastro['Sigla do Partido'], cadastro['Cargo'], cadastro['Sexo'])
        raw_input()
        main()
        
    elif funcionalidade == '3':
        sexo = raw_input('qual o sexo para pesquisa(M|F): ')
        contador = 0
        contador_2 = 0
        for cadastro in banco_de_dados:
            contador = contador + 1
        for cadastro in banco_de_dados:
            if cadastro['Sexo'] == sexo.upper():
                contador_2 = contador_2 + 1
        print 'quantidade de candidatos do sexo e de %s' % contador_2
        print 'porcentagem de candidatos do sexo e de %s%%' % ((contador_2/contador)*100)
        raw_input()
                
    elif funcionalidade == '4':
        numero = input('qual o numero do candidato')
        for cadastro in banco_de_dados:
            if cadastro['Numero'] == numero:
                print ('ID: %s, Nome: %s, Numero: %s, Sigla do Partido: %s, Cargo: %s, Sexo: %s') % (cadastro['ID'], cadastro['Nome'], cadastro['Numero'], cadastro['Sigla do Partido'], cadastro['Cargo'], cadastro['Sexo'])
        raw_input()
        main()
    elif funcionalidade == '5':
        main()
        
                
def terminar():
    quit()
    
if __name__ == '__main__':
    main()
