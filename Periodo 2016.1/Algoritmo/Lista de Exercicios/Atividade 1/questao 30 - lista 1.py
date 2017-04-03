#_*_ coding: utf-8 _*_

n=input("Insira o total em minutos: ")
print " %d Dia(s) %d Hora(s) %d Minuto(s)" % ((n/1440),((n%1440)/60),((n%1440)%60))