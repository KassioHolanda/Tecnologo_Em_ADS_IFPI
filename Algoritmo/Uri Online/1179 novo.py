#coding:utf-8
def main():
    impar = []
    par = []
    novo_par = []
    novo_impar = []
    for i in range(15):
        numeros = input('adicione 15 numeros: ')
        if (numeros % 2) == 0:
            par.append(numeros)
     pares(par, impar)

def pares(par, impar):
    if len(par) > 5:
        for p in range(5):
            print'par[%d] = %d' % (p, par[p])
            del par[p]
        #novo_par.append(par)
    elif len(par) < 5:
            for p in range(len(par)):
                print'par[%d] = %d' % (p, par[p])
    impares(impar, par)

def impares(impar, par):
    
    if len(impar) > 5:      
        for i in range(5):
            print'impar[%d] = %d' % (i, impar[i])
            del impar[i]
        #novo_impar.append(impar)
    elif len(impar) < 5:
        if len(impar) > 0:
            for i in range(len(impar)):
                print'impar[%d] = %d' % (i, impar[i])
        
    parada(par, impar)



        
if __name__ == "__main__":
    main()
