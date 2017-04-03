#_*_ coding: utf-8 _*_
#6 - Leia uma velocidade em km/h, calcule e escreva esta velocidade em m/s. (Vm/s = Vkm/h / 3.6)

vel_kmh = float(input("digite uma velocidade em km/h: "))
vel_ms = vel_kmh*3.6
print ("a velocidade %.2f em Km/s equivale a %.2f em M/S" % (vel_kmh, vel_ms))
