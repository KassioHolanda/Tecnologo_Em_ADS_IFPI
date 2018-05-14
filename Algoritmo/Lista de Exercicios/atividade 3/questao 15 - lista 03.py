#-*- coding: utf-8 -*-

#Leia N, calcule e escreva os N primeiros termos de seqüência (1, 3, 6, 10, 15,...). 

def numeros(num):
        for lista in range(1,num):
                n = 2
                while num >= lista:
                        print lista,
                        lista = n + lista
                        n += 1
                break

def main():
        num = input("escreva um numero de limite: ")
        numeros(num)

if __name__ == "__main__":
        main()

        

                
               
                
                
