#-*- coding: utf-8 -*-
# Leia N e uma lista de N números e escreva o maior número da lista. 
def numeros(numero):
        for lista in range(1,numero):
                while numero - 1 == lista:  
                        print "o maior numero dessa lista é %d" % lista
                        break
        
def main():
	numero = input("digite a quantidade de numeros de uma lista: ")
	numeros(numero)


if __name__ =="__main__":
	main()
