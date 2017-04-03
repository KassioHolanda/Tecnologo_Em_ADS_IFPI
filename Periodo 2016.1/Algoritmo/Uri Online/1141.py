#coding:utf-8
def main():
	strings = []
	numero = input()
	for i in range(numero):
		strings.append(raw_input())

	print len(strings)


if __name__ == '__main__':
	main()