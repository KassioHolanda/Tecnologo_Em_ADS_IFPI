def numeros(inicio, fim):
    for i in range(inicio,fim):
        if i % 2 == 0:
            print i

def main():
    fim = int(input("digite ate qnd vc deseja contar: "))
    numeros(1, fim + 1)

if __name__ == "__main__":
    main()
