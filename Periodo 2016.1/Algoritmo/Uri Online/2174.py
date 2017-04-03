def main():
	pokemons = []
	abc = []
	total_pokemon = 151
	N = input()
	for i in range(N):
		S = raw_input()
		pokemons.append(S.title())
	for i in pokemons:
		if i not in abc:
			abc.append(i)
	restantes =  total_pokemon - len(abc)
	print 'Falta(m) %d pomekon(s).' % (restantes)

if __name__ == '__main__':
	main()
