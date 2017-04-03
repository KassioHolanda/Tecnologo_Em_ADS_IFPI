#coding:utf-8
def main():
	vetor = []
	novo_vetor = []
	while True:
		nome = str(input())
		if len(nome) == 0:
			break
		else:
			vetor.append(nome)
			novo_vetor.append(nome.lower())
			#print (max(novo_vetor))
			#print (vetor)
			continue
	for i in vetor:
		if max(novo_vetor) == i.lower():
			print (i)

if __name__ == '__main__':
	main()
