def main():
    numeros = []
    
    for i in range(10):
        numeros.append(input())
        
    for i in range(10):
        if int(numeros[i]) <= 0:
            numeros[i] = 1

    for i in range(10):
        print "X[%d] = %d" % (i, numeros[i])
       
            
if __name__ == "__main__":
    main()

'''
def main():
    numeros = []

    #receber numeros
    for i in range(10):
        numeros.append(input())

    #aplicar regra
        for i in range(10):
            if int(numeros[i]) <= 0:
                numeros[i] = 1

    #escrever resultado
                for i in range(10):
                    print 'x[%d] = %d ' % (i, numeros[i])


if __name__ == '__main__':
    main()
'''
