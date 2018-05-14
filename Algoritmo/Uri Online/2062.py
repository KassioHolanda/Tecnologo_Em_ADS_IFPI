def main():
	N = input()
	p = raw_input().split(' ')
	palavras = []
	novas_palavras = []
	for i in range(N):
		palavras.append(p[i].upper())
	for i in palavras:
		if len(i) == 3 and i.startswith('UR'):
			novas_palavras.append(i.replace(i,'URI'))
		elif len(i) == 3 and i.startswith('OB'):
			novas_palavras.append(i.replace(i,'OBI'))
		else:
			novas_palavras.append(i)
	for i in novas_palavras:
		print i,

if __name__ == '__main__':
	main()