'''Escreva um algoritmo que calcula o retorno de um investimento financeiro. O usuário deve informar
quanto será investido por mês e qual será a taxa de juros mensal. O algoritmo deve informar o saldo do
investimento após um ano (soma das aplicações mensais + juros compostos), e perguntar ao usuário se
deseja calcular o ano seguinte, sucessivamente. Por exemplo, caso o usuário deseje investir R$ 100,00
por mês, e tenha uma taxa de juros de 1% ao mês, o algoritmo forneceria a seguinte saída:
Saldo do investimento após 1 ano: 1268.25
Deseja processar mais um ano (S/N) ?'''


novo_total = 0
resposta = None
investimento = float(input('Informe o quanto você quer investir: '))
juros = float(input('Informe o valor do juros mensal: '))
juros_calculado = juros/100
total = investimento * (1 + juros_calculado)**12
print('Depois de um ano você terá: %.2f ' % total)
while resposta != 'n':
    resposta = input('Deseja processar mais um ano? (s/n): ')
    if resposta == 's':
        novo_total = total * (1 + juros_calculado)**12
        print('O novo total é: %.2f' %novo_total)
        total = novo_total
    else:
        print('Obrigado!')



