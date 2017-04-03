def main():
    qtd = input("qtd: ")
    n1 = 0
    n2 = 1
    print n1, n2,
    for i in range(qtd - 2):
        atual = n1 + n2
        n1 = n2
        n2 = atual
        print atual,

if __name__ == "__main__":
    main()