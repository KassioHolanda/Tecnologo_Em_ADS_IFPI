#_*_ coding: utf-8 _*_
#21.  Leia uma temperatura em °F, calcule e escreva a equivalente em °C. (t°C = (5 * t°F - 160) / 9).

temp_F = float(input("insira uma temperatura em Farhenheit: "))
F_C = ((5 * temp_F - 160)/ 9)
print(" essa temperatura em Farhenheit equivale a %.4f" % (F_C))
