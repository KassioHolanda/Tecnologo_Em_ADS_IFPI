#_*_ coding: utf-8 _*_
#12.  Leia o salário de um trabalhador e escreva seu novo salário com um aumento de 25%.

salario = float(input("digite seu salario: "))
novo_salario = (salario * 0.10) + salario
print (" o novo salario sera %.2f" % (novo_salario))
