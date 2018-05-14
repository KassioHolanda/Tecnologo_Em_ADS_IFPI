def sequencia():
    n = 61
    t = input()
    n1 = 0
    n2 = 1
    lista = [n1, n2]
    for i in range(n - 2):
        atual = n1 + n2
        lista.append(atual)
        n1 = n2
        n2 = atual

    list_fibo = []
    for i in range(t):
        list_fibo.append(int(input()))

    for i in range(t):
        print 'Fib(%d) = %d' % (list_fibo[i], lista[list_fibo[i]])    

def main():
    sequencia()

    

if __name__ == "__main__":
    main()
