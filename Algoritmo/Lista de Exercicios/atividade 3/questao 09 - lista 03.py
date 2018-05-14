#-*- coding: utf-8 -*-
#Leia LimiteSuperior e LimiteInferior e escreva todos os números pares entre os limites lidos.

def limites(limiteinferior, limitesuperior):
	for i in range(limiteinferior,limitesuperior):
		if i % 2 == 0:
			print "os numeros pares existentes são %d" % (i)

def main():
	limiteinferior = input("digite um numero para limite inferior: ")
	limitesuperior = input("ditite um numero para limite superior: ")
	limites(limiteinferior,limitesuperior)

if __name__ == "__main__":
	main()
