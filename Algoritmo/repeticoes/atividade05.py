'''Leia dois números X e N. A seguir, escreva o resultado das divisões de X por N onde, após cada
divisão, X passa a ter como conteúdo o resultado da divisão anterior e N é decrementado de 1 em 1, até
chegar a 2. '''

numero1 = float((input('Informe o primeiro número: ')))
numero2 = float((input('Informe o segundo número: ')))
while numero2 >= 2:
    resultado = float(numero1/numero2)
    numero1 = resultado
    numero2 -= 1
    print('%.2f' % numero1)