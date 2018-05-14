#coding:utf-8
def main():
    impar = []
    par = []
    numero = 0
    soma = 0

    while soma < 15:
        valor = input()
        soma += 1   
        
        if valor % 2 == 0:
            par.append(valor)
        else:
            impar.append(valor)
        if len(par) == 5:
            for i in range(len(par)):
                print 'par[%d] = %d' %(i, par[i])
            par = []
        if len(impar) == 5:
            for i in range(len(impar)):
                print 'impar[%d] = %d' %(i, impar[i])
            impar = []

    for i in range(len(impar)):
        print 'impar[%d] = %d' %(i, impar[i])

    for i in range(len(par)):
        print 'par[%d] = %d' %(i, par[i])

if __name__ == '__main__':
    main()
