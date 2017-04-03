def main():
        numeros_pares = ''
        numeros_impares = ''
        n_impar = ''
        n_par = ''
        novo_numeros_impares = ''
        novo_numeros_pares = ''
        N = input()
        for i in range(N):
                numero = raw_input()
                if eval(numero) % 2 == 0:
                        numeros_pares += (numero + ' ')
                if eval(numero) % 2 != 0:
                        numeros_impares += (numero + ' ')
        numeros_pares = numeros_pares.split()
        numeros_impares = numeros_impares.split()
        
        contador_impar = 0
        contador_par = 0

        for i in numeros_impares:
                contador_impar += 1
        for i in numeros_pares:
                contador_par += 1

        vetor = numeros_pares
        for i in range(1, contador_par):
                valor = vetor[i]
                posicao = i
                while posicao > 0 and vetor[posicao-1] > valor:
                        vetor[posicao] = vetor[posicao-1]
                        posicao = posicao-1
                vetor[posicao] = valor
        n_par += str(vetor)
        
        vetor = numeros_impares
        for i in range(1, contador_impar):     
                valor = vetor[i]
                posicao = i
                while posicao > 0 and vetor[posicao-1] > valor:
                        vetor[posicao] = vetor[posicao-1]
                        posicao = posicao-1
                vetor[posicao] = valor
        n_impar += str(vetor)

         
        for i in range(contador_par):
                novo_numeros_pares += n_par[i]
        for i in range(contador_impar-1,-1,-1):
                novo_numeros_impares += numeros_impares[i]
        for i in novo_numeros_pares:
                print i
        for i in novo_numeros_impares:
                print i
    
if __name__ == '__main__':
        main()
