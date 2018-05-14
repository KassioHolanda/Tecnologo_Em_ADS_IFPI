#coding:utf-8
def main():
    numeros = []
    
    for i in range(10):
        numeros.append(input())

    for i in range(10):
        if numeros[i] <= 10:
            print "A[%d] = %.1f" % (i, numeros[i])

          
if __name__ == "__main__":
    main()


