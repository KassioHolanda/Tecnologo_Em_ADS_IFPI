#coding:utf-8


def inicializa():
	arquivo_alunos = open('banco_de_dados_alunos.txt', 'r')
	linhas = arquivo_alunos.readlines()
	banco_de_dados_alunos = []
	for linha in linhas:
		banco_de_dados_alunos.append(eval(linha))
	arquivo_alunos.close()


banco_de_dados_alunos = inicializa()
def main(banco_de_dados_alunos):
	print'sistema de cadastro de alunos'
	print''
	raw_input('aperte um botao para seguir para o menu de opcoes')
	funcionalidade = raw_input('digite\n1 - para cadastrar aluno\n2 - para listar alunos\n3 - para apagar alunos\n4 - para sair')
	if funcionalidade == '1':
		arquivo_alunos = open('banco_de_dados_alunos.txt', 'w')
		banco_de_dados_alunos.append(cadastrar_aluno(banco_de_dados_alunos))
		for cadastro in banco_de_dados_alunos:
			arquivo_alunos.writelines(str(cadastro) + '\n')
		arquivo_alunos.close()
		main(banco_de_dados_alunos)
	elif funcionalidade == '2':
		listar_alunos(banco_de_dados_alunos)
	elif funcionalidade == '3':
		remover_aluno()
	elif funcionalidade == '4':
		terminar()
	else:
		print'digite uma opção do menu'
	main(banco_de_dados_alunos)

def cadastrar_aluno(banco_de_dados_alunos):
	print'area de cadastro de aluno'
	nome = raw_input('qual nome do aluno: ')
	idade = input('qual a idade do aluno: ')
	sexo = raw_input('qual o sexo do aluno( M ou F ): ')
	if sexo.upper() == 'M':
		sexo = 'Masculino'
	else:
		sexo = 'Feminino'
	curso = raw_input('qual o curso que o aluno faz: ')
	cadastro = {'Nome': nome.upper(), 'Idade': idade, 'Genero': sexo.upper(), 'Curso': curso.upper()}
	return cadastro

def listar_alunos(banco_de_dados_alunos):
	for alunos in banco_de_dados_alunos:
		print'Aluno: %s, Idade: %s, Genero: %s, Curso: %s' % (alunos['Nome'], alunos['Idade'], alunos['Genero'], alunos['Curso'])
	raw_input('listagem de alunos fnalizada')
	main(banco_de_dados_alunos)



#def remover_alunos(banco_de_dados):


def terminar():
	print('FIM')
	quit()




if __name__ == '__main__':
	main(banco_de_dados_alunos)