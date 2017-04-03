#_*_ coding: utf-8 _*_
#"2.  Leia um valor em horas e um valor em minutos, calcule e escreva o equivalente em minutos.)

val_hrs = float(input("escreva um valor em Hrs: "))
val_min = float(input("escreva um valor em min: "))
val_t_min = val_hrs*60 + val_min
print ("o valor equivalente tota é de %.2f R$" % (val_t_min))

