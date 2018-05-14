#_*_ coding: utf-8 _*_


num = float(input("digite um num: "))
cont = num -1
produto = num

while ( cont > 1 ):
    cont = (num * cont)
    cont = cont - 1

print (produto)