#coding:utf-8
def main():
    numeros = []
    T = input()
    valores = 0
    for i in range(1000):
        numeros.append(valores)
        valores += 1
        if valores >= T:
        	valores = 0

    for x in range(1000):
        print 'N[%d] = %d' % (x,numeros[x])
            
         
if __name__ == "__main__":
    main()
