def tabuada(numero, contador):
    while contador <= 10:
        print(numero * contador)
        contador += 1

def main():
    numero = int(input('Informe um número: '))
    contador = int(input('Informe um Início: '))
    tabuada(numero, contador)

if __name__ == '__main__':
    main()