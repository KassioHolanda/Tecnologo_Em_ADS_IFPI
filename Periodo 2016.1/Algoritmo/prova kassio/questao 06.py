nome = raw_input("digite o nome do vendedor: ")
sal_fix = float(input("digite o salario fixo do vendedor: "))
tota_vendas = float(input("digite o total de vendas: "))

total_sal = (0.15 * tota_vendas) + sal_fix

print("o salario total a ser recebido sera de %.2f" % (total_sal))
