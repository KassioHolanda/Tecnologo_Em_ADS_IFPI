def main():
    vetor = []
    N = input('tamanho do vetor: ')
    lista = ([int(i) for i in raw_input().split()])
    for i in range(0,N):
        vetor.append(lista[i])
    print'Menor valor: %d\nPosicao: %d' % (min(vetor), vetor.index(min(vetor)))

    
    
if __name__ == '__main__':
    main()


