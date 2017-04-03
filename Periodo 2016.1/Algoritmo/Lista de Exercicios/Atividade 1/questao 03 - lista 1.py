#_*_ coding: utf-8 _*_
#3 - Leia um valor em minutos, calcule e escreva o equivalente em horas e minutos.

min = int(input("digite um valor em minutos: "))
hrs = int(min / 60)
min_r = int(min % 60)
print ("%.f horas e %.f minutos" % (hrs, min_r))

