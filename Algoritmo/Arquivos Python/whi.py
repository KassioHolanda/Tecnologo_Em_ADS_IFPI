#-*- coding: utf-8-*-
"""
n = int(input("digite o primeiro numero: "))
while (n!=0):
	print(n,"ao quadrado = ", n*n)
	n = int(input("digite o proximo numero: "))
"""
"""
i = 0
n = 5
j = 0

while i < 4:
	while (j < 7):
		print (i, j)
		j = j + 1
	i = i + 1
"""



print("questao 2")
def verifica_numeros(num1,num2):
    if num1> num2:
        return ("O numero %d é maior que o numero %d." % (num1, num2))
    elif num1< num2:
        return ("O numero %d é maior que o numero %d." % (num2,num1))
    else:
        return ("Os numeros %d e %d sao iguais." %(num1, num2))
def main():
    print("Programa comparativo de numeros")
    num1 = int(input("digite o primeiro numero: "))
    num2 = int(input("digite o segundo numero: "))
    verifica_numeros(num1, num2)
    print(verifica_numeros(num1,num2))

if __name__== "__main__":
    main()



