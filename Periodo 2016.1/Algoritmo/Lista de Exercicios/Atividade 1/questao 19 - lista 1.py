#_*_ coding: utf-8 _*_
#19.  Leia o valor do raio de uma esfera, calcule e escreva seu volume. (v = (4 * p * r³)/3)

p=3.14
print ("pense em um circunferencia, imagine as suas medidas e responda: ")
raio = float(input("digite o valor do raio da circunferencia: "))

volume = ((4 * p * raio**3)/3)

print ("o valor do volume da esfera é de %.2f" %  (volume))
