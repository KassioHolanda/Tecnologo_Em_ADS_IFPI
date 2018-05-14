

cotacao = int(input ("escreva a cotação do dollar: "))
vlr_dollar = int(input ("digite um valor em U$:"))
vlr_reais = float(cotacao*vlr_dollar)

print("o valor %.2f dolares com cotação a %.2f equivale a %.2f" % (vlr_dollar,cotacao,vlr_reais))


cotacao = input ("escreva a cotação do dollar: ")
vlr_dollar = input ("digite um valor em U$:")
vlr_reais = cotacao*vlr_dollar

print("o valor %.2f dolares com cotação a %.2f equivale a %.2f" % (vlr_dollar,cotacao,vlr_reais))