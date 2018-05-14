#Leia 2 (dois) números, calcule e escreva o mmc (mínimo múltiplo comum) entre os números lidos.
def mmc(numero1, numero2, conta_fator1, conta_fator2):
    while numero1 >= 1 and numero2 >= 1:
        if numero1 % 2 == 0 and numero2 % 2 == 0:
            fator1 = numero1 / 2
            fator2 = numero2 / 2
            continue
        if numero1 % 3 == 0 and numero2 % 3 == 0:
            fator1 = numero1 / 3
            fator2 = numero2 / 3
            continue
        if numero1 % 4 == 0 and numero2 % 4 == 0:
            fator1 = numero1 / 4
            fator2 = numero2 / 4
            continue
        if numero1 % 4 == 0 and numero2 % 4 == 0:
            fator1 = numero1 / 4
            fator2 = numero2 / 4
            continue
        if numero1 % 5 == 0 and numero2 % 5 == 0:
            fator1 = numero1 / 5
            fator2 = numero2 / 5
            continue
        if numero1 % 6 == 0 and numero2 % 6 == 0:
            fator1 = numero1 / 6
            fator2 = numero2 / 6
            continue
        if numero1 % 7 == 0 and numero2 % 7 == 0:
            fator1 = numero1 / 7
            fator2 = numero2 / 7
            continue
        if numero1/conta_fator1 == 0 and numero2/conta_fator2 == 0:
            break
        conta_fator1 += fator1
        conta_fator2 += fator2
        print(conta_fator1, conta_fator2)

    mmc = fato1 * fator2
    print('O mmc é igual a %d' % mmc)

mmc(4,6,0,0)




