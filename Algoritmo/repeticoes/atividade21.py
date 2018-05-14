'''Leia 2 números inteiros e escreva a multiplicação dos mesmos, sem que o operador de multiplicação (*)
seja utilizado.'''

valor1 = int(input('Informe o primeiro número: '))
valor2 = int(input('Informe o segundo núemero: '))
multiplicacao = 0
while valor2 >= 1:
    multiplicacao += valor1
    valor2 -= 1 # valor2 = valor2 - 1
print('A multiplicacao é dos valores é %d' % multiplicacao)