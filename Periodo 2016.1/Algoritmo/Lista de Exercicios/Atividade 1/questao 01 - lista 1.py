#_*_ coding: utf-8 _*_

#1 - Leia uma velocidade em m/s, calcule e escreva esta velocidade em km/h. (Vkm/h = Vm/s * 3.6)

vel_ms = int(input("esqueva uma velocidade em M/s: "))
vel_km = float(vel_ms * 3.6)
print (" a velocidade %.2f M/s equivale a %.2f em K/h" % (vel_ms, vel_km))
