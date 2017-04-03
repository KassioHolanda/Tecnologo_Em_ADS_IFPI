#-*- coding: utf-8 -*-

def progressao_geometrica(valor_inicial, limite, razao):
    valor_atual = valor_inicial
    while valor_atual < limite:
        print valor_atual
        valor_atual = valor_atual + razao
def main():
    valor_inicial = input("digite um valor inicial: ")
    limite = input("digite um valor para limite: ")
    progressao_geometrica(valor_inicial, limite, 2)


if __name__ == "__main__":
    main()