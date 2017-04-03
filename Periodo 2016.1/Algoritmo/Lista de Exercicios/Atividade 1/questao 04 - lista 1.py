#_*_ coding: utf-8 _*_
# 4 - Leia o valor do dólar e um valor em dólar, calcule e escreva o equivalente em real (R$).

cotacao = float(input("qual a cotação do dolar?: "))
vlr_dolar = float(input ("digite um valor em dolar?: "))

vlr_reais = (vlr_dolar * cotacao)
print ("o valor equivalente de %.2f R$ é de %.2f U$" % (vlr_dolar, vlr_reais))