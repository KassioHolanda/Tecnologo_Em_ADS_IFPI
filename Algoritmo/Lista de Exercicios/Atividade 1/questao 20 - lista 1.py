#_*_ coding: utf-8 _*_
# 20.  Leia uma temperatura em °C, calcule e escreva a equivalente em °F. (t°F = (9 * t°C + 160) / 5)

T_C = float(input("digite uma temperatura em C"))
T_F = (9 * T_C + 160) / 5

print("o equivalente de %.2f C para F é %.2f" % (T_C, T_F))





