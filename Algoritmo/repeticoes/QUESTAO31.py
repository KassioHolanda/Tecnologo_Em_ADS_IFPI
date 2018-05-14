# -*- coding: utf-8 -*-
"""
30. Escreva um algoritmo que leia o nome de um produto, o preço e a quantidade comprada. Escreva o nome do produto comprado
e o valor total a ser pago, considerando que são oferecidos descontos pelo número de unidades compradas, segundo a tabela abaixo:
(FLAG: nome do produto = “FIM”).
a. Até 10 unidades: valor total
b. de 11 a 20 unidades: 10% de desconto
c. de 21 a 50 unidades: 20% de desconto
d. acima de 50 unidades: 25% de desconto
"""
nome = raw_input('Digite o nome do produto: ')
preco = input('Digite o preço do produto: ')
quantidade = input('Digite a quantidade de produtos: ')

if quantidade <= 10:
    print 'Você não tem direito a descontos. Valor total a ser pago:R$ %.2f' % (preco)

if quantidade > 10 and quantidade <= 20:
    desconto = preco*0.90
    print 'Seu desconto é de %10. Valor total a ser pago pelos(as) {}:R$ {}' .format(nome,desconto)

if quantidade > 20 and quantidade <= 50:
    desconto = preco*0.80
    print 'Seu desconto é de %20. Valor total a ser pago pelos(as) {}:R$ {}' .format(nome,desconto)

if quantidade > 50:
    desconto = preco*0.75
    print 'Seu desconto é de %25. Valor total a ser pago pelos(as) {}:R$ {}' .format(nome,desconto)
