# -*- coding: utf-8 -*-

#8.  Leia N , LimiteSuperior e LimiteInferior e escreva todos os múltiplos de N entre os limites lidos. 

def limites(n, limiteinferior, limitesuperior):
	for i in range(limiteinferior,limitesuperior):
		if i % n == 0:
			print i

def main():
	n = input("digite um numero para n: ")
	limiteinferior = input("digite um numero para limite inferior: ")
	limitesuperior = input("ditite um numero para limite superior: ")
	limites(n, limiteinferior,limitesuperior)

if __name__ == "__main__":
	main()


