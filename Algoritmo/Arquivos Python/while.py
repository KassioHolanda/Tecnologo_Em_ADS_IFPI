#_*_ coding: utf-8 _*_

n = input("voce deseja contar ate qnt? ")
salto = input("de quanto vai ser o salto? ")


cont = 0
while cont <= n:
    print(cont)
    cont = cont + salto



#_*_ coding: utf-8 _*
from math import pow

base = int(input("digite um numero: "))
exp = int(input("digite outro numero: "))

resl = pow(base,exp)

print("o resultado da equação será: %.d" % (resl))



base = int(input("digite o valor da base: "))
expoente = int(input("digite o valot do expoente: "))

cont = 0
produto = 1
while cont < expoente:
	produto = produto * base
	cont = cont + 1

print(base, "elevado a", expoente, "=", produto)




#dado um numero inteiro noa negativo n, determinar n!
#5! = 5*4*3*2*1 = 120
#3! = 3*2*1 = 6

numero = int(input("digite um numero: "))
produto = numero
cont = numero
while (cont < 1):
	produto = produto * (cont + 1)
	cont = cont + 1
print("%d ! = %d" % (numero, produto))






	