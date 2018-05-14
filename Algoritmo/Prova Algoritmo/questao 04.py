def main():
        numeros_pares = []
        numeros_impares = []
        novo_numeros_impares = []
        maior = 0
        N = input()
        for i in range(N):
                numero = input()
                if numero % 2 == 0:
                        numeros_pares.append(numero)
                else:
                        numeros_impares.append(numero)
        numeros_pares.sort()
        numeros_impares.sort()        
        for i in numeros_pares:
                print i
        for i in range(len(numeros_impares)-1,-1,-1):
                novo_numeros_impares.append(numeros_impares[i])
        for i in novo_numeros_impares:
                print i
        
        


if __name__ == '__main__':
        main()
