def main():
	tomadas = [int(i) for i in raw_input().split()]
	tomada_1 = tomadas[0] - 1
	tomada_2 = tomadas[1] - 1
	tomada_3 = tomadas[2] - 1
	tomada_4 = tomadas[3]
	num_tomadas = tomada_1 + tomada_2 + tomada_3 + tomada_4

	print num_tomadas


if __name__ == '__main__':
	main()