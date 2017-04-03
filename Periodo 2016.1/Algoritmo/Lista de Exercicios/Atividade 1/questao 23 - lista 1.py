#_*_ coding: utf-8 _*_

#Leia um valor em kg (quilograma), calcule e escreva o equivalente em g (grama).

kilo = float(input("digite um valor em Kg: "))
grama = (kilo * 1000)

print ("o valor de %.2f kg equivale a %.2f em gramas" % (kilo,grama))
