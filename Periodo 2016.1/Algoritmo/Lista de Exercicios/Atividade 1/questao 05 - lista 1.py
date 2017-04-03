#_*_ coding: utf-8 _*_
#5 - Leia um número inteiro (3 dígitos), calcule e escreva a soma de seus elementos (C + D + U).

valor = int(input("Digite um numero inteiro de 3 digitos: "))
centena = valor / 100
dezena = (valor % 100) / 10
unidade = (valor % 10)
valor_total = centena + dezena + unidade
print ("A soma dos tres digitos do valor %d eh %d" %(valor, valor_total))

