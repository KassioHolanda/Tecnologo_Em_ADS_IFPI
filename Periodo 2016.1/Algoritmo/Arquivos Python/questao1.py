#1 - Leia uma velocidade em m/s, calcule e escreva esta velocidade em km/h. (Vkm/h = Vm/s * 3.6)
"""
vel_ms = int(input("esqueva uma velocidade em M/s: "))
vel_km = float(vel_ms * 3.6)
print (" a velocidade %.2f M/s equivale a %.2f em K/h" % (vel_ms, vel_km))
"""

#2.  Leia um valor em horas e um valor em minutos, calcule e escreva o equivalente em minutos.
""""
val_hrs = input ("escreva um valor em Hrs: ")
val_min = input ("escreva um valor em min: ")
val_t_min = val_hrs*60 + val_min
print ("o valor equivalente tota é de %.2f R$" % (val_t_min))
"""

#3 - Leia um valor em minutos, calcule e escreva o equivalente em horas e minutos.
"""
min = int(input("digite um valor em minutos: "))
hrs = int(min / 60)
min_r = int(min % 60)
print ("%.f horas e %.f minutos" % (hrs, min_r))
"""

#4 - Leia o valor do dólar e um valor em dólar, calcule e escreva o equivalente em real (R$).
"""
cotacao = float(input("qual a cotação do dolar?: "))
vlr_dolar = float(input ("digite um valor em dolar?: "))

vlr_reais = (vlr_dolar * cotacao)
print ("o valor equivalente de %.2f R$ é de %.2f U$" % (vlr_dolar, vlr_reais))
"""

#5 - Leia um número inteiro (3 dígitos), calcule e escreva a soma de seus elementos (C + D + U).
"""
valor = int(input("Digite um numero inteiro de 3 digitos: "))
centena = valor / 100
dezena = (valor % 100) / 10
unidade = (valor % 10)
valor_total = centena + dezena + unidade
print ("A soma dos tres digitos do valor %d eh %d" %(valor, valor_total))
"""

#6 - Leia uma velocidade em km/h, calcule e escreva esta velocidade em m/s. (Vm/s = Vkm/h / 3.6)
"""
vel_kmh = float(input("digite uma velocidade em km/h: "))
vel_ms = vel_kmh*3.6
print ("a velocidade %.2f em Km/s equivale a %.2f em M/S" % (vel_kmh, vel_ms))
"""

#7 - Leia 3 números, calcule e escreva a soma dos 2 primeiros e a diferença entre os 2 últimos.
"""
num1 = float(input("digite o primeiro numero: "))
num2 = float(input("digite o segundo numero: "))
num3 = float(input("digite o terceiro numero: "))

soma1 = num1 + num2
diferenca1 = num2/num3

print ("a soma dos dois primeiros numero é %.2f e a diferença dos dois ultimos numeros é %.2f" % (soma1, diferenca1))
"""

#8 - Leia 2 números, calcule e escreva a divisão da soma pela subtração dos números lidos.
"""
num1 = float(input("digite o primeiro número: "))
num2 = float (input("dgite o segundo numero: "))


soma = float(num1+num2)
subtracao = float(num1 - num2)
divisao= float(soma/subtracao)

print ("a soma dos numeros e %d, a subtração dos numero é %d, sendo que a divisao da soma pela subtração é %d" % (soma, subtracao, divisao))
"""

#9 - Leia 2 números (A, B) e escreva-os em ordem inversa (B, A).
"""
num1 = float(input("digite o primeiro numero: "))
num2 = float(input("digite o segunod numero: "))

print ("o valor do primeiro numero é: %d, e o valor do segundo numero é: %d" % (num2, num1))
"""

#10 - Leia 2 números inteiros, calcule e escreva o quociente e o resto da divisão do 1o pelo 2o.
"""
num1 = float(input("digite o primeiro numero: "))
num2 = float(input("digite o segundo numero: "))

quociente =  num1 / num2
resto = num1%num2

print ("o quociente e o resto da divisao dos numeros sao respctivamente: %.2f e %.2f" % (quociente,resto))
"""

#11.  Leia um número inteiro (3 dígitos) e escreva o inverso do número. (Ex.: número = 532 ; inverso = 235)
"""
num = int(input("Digite um numero inteiro com tres digitos: "))
print (num[::-1])
"""

#12.  Leia o salário de um trabalhador e escreva seu novo salário com um aumento de 25%.
"""
salario = float(input("digite seu salario: "))
novo_salario = (salario * 0.10) + salario
print (" o novo salario sera %.2f" % (novo_salario))
"""
#13.  Leia um valor em real (R$), calcule e escreva 70% deste valor.
"""
val = float(input("digite um valor em R$: "))
par = (val * 0.70)
print ("70%% de %.2f R$ é igual a %.2f R$" % (val, par))
"""

#14.  Leia 3 notas de um aluno e o peso de cada nota, calcule e escreva a média ponderada.
"""
nota1 = float(input("digite a nota 1: "))
nota2 = float(input("digite a nota 2: "))
nota3 = float(input("digite a nota 3: "))
peso1 = float(input("digite peso da nota 1: "))
peso2 = float(input("digite peso da nota 2: "))
peso3 = float(input("digite peso da nota 3: "))

media = (nota1 * peso1) + (nota2 * peso2) + (nota3 + peso3)

print ("A média ponderada de %d , %d, %d, considerando os pesos %d , %d , %d respectivamente é: %d " % (nota1,nota2,nota3,peso1,peso2,peso3,media))
"""

#15.  Leia o valor da base e altura de um triângulo, calcule e escreva sua área. (área=(base * altura)/2)
"""
print ("pense em um triangulo, imagine as suas medidas e responda:")
base = float(input("qual o valor da base desse triangulo"))
altura = float(input("qula o valor da altura desse triangulo"))
area = ((base * altura)/2)

print("a area desse determinado triangulo é de %.2f" % (area))
"""

#16.  Leia o valor do lado de um quadrado, calcule e escreva sua área. (área = lado²)
"""
print ("pense em um quadrado, imagine as suas medidas e responda: ")
lado = float( input("digite o tamanho do lado do quadrado: "))
area = (lado ** 2)

print ("a area do quadrado é igual a %.2f" % (area))
"""

#17.  Leia o valor da base e altura de um retângulo, calcule e escreva sua área. (área = base * altura)
"""
print ("pense em um retangulo, imagine as suas medidas e responda: ")
base = float(input("qual o tamanho da base desse triangulo: "))
altura = float(input("digite a altura desse triangulo: "))
area = base * altura

print (" a area do retangulo sera de %.2f " % (area))
"""

#18.  Leia o valor do raio de uma circunferência, calcule e escreva seu comprimento.(c = 2 * p * r)
"""
p = 3.14
print ("pense em um circunferencia, imagine as suas medidas e responda: ")
raio = float(input("digite o valor do raio da circunferencia: "))
comprimento = (2 * p * raio)

print ("o comprimento da circunferencia é de %.2f" % (comprimento))
"""

#19.  Leia o valor do raio de uma esfera, calcule e escreva seu volume. (v = (4 * p * r³)/3)
"""
p=3.14
print = ("pense em um circunferencia, imagine as suas medidas e responda: ")
raio = float(input("digite o valor do raio da circunferencia: "))

volume = (4 * p * raio**3)/3)

print ("o valor do volume da esfera é de %.2f" %  (volume))
"""

#20.  Leia uma temperatura em °C, calcule e escreva a equivalente em °F. (t°F = (9 * t°C + 160) / 5)

T_C = float(input("digite uma temperatura em C"))
T_F = (9 * T_C + 160) / 5

print("o equivalente de %.2f C para F é %.2f" % (T_C, T_F))


#





