#coding:utf-8
def main():
	vetor = []
	N = input()
	for i in range(N):
		nome = raw_input()
		nome = nome.title()
		for i in nome:
			if i.istitle() == True:
				vetor.append(i)
			else:
				continue
	
	print vetor



if __name__ == '__main__':
	main()