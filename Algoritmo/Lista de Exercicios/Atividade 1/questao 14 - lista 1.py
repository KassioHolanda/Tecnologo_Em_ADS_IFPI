#_*_ coding: utf-8 _*_
#14.  Leia 3 notas de um aluno e o peso de cada nota, calcule e escreva a média ponderada.

nota1 = float(input("digite a nota 1: "))
nota2 = float(input("digite a nota 2: "))
nota3 = float(input("digite a nota 3: "))
peso1 = float(input("digite peso da nota 1: "))
peso2 = float(input("digite peso da nota 2: "))
peso3 = float(input("digite peso da nota 3: "))

media = (nota1 * peso1) + (nota2 * peso2) + (nota3 + peso3)

print ("A média ponderada de %d , %d, %d, considerando os pesos %d , %d , %d respectivamente é: %d " % (nota1,nota2,nota3,peso1,peso2,peso3,media))
