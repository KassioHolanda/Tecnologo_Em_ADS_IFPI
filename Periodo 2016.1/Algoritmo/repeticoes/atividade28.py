'''Escreva um algoritmo que gere um número aleatório inteiro (utilize a função rand(): aleatorio = rand())
e solicite um número ao usuário. O objetivo é que o usuário acerte o número gerado. Se o número
digitado for menor que o gerado, escreva “Maior”, se for maior, escreva “Menor”, e solicite novamente
um número ao usuário. Repita este processo ate que o usuário acerte o número gerado. Após isso,
escreva em quantas tentativas o usuário acertou.'''
from random import randint

valor = int(input('Vamos brincar... tente adivinhar o número que estou pensando entre 0 e 10: '))
tentativas = 1
aleatorio = randint(0,10)
while valor != aleatorio:
    if valor > aleatorio:
        print('Quase em... mas o número que estou pensando é MENOR!')
        valor = int(input('Infome um novo valor: '))
    if valor < aleatorio:
        print('kkkkkkkkk... o número que estou pensando é MAIOR!')
        valor = int(input('Infome um novo valor: '))
    tentativas += 1 # tentativas = tentativas + 1
print('O número que pensei foi %d! Parabens, você acertou em %d tentativas!' % (aleatorio,tentativas))


