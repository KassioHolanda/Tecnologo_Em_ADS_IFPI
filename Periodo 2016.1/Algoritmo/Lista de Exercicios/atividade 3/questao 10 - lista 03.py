""" LÊ LIMITE 1 E 2 E IMPRIME NUMEROS IMPARES """

def limites(limitesuperior, limiteinferior):
    for i in range (limitesuperior, limiteinferior):
        if i % 2 != 0:
            print i


def main():
    limitesuperior = input("digite um numero pra limite superior: ")
    limiteinferior = input("digite um numero para limite inferior: ")
    limites(limitesuperior, limiteinferior)

if __name__ == "__main__":
    main()


