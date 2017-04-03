#_*_ coding: utf-8 _*_

#26.  Leia um número inteiro de dias, calcule e escreva quantas semanas e quantos dias ele corresponde. 

dia = int(input("escreva um numero relacionado a dias: "))
semanas = (dia/7)
dias = (dia%7)

print ("%d semanas e %d dias" % (semanas, dias))