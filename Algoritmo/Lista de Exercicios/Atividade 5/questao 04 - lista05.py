
'''
Leia 2 vetores A e B com N elementos, escreva e escreva um vetor C, que represente o conjunto união 
entre os vetores A e B; e um vetor D, que represente o conjunto interseção entre os vetores A e B.
'''

def main():
    quantidade_A = input('digite a quantidade de numeros do vetor A: ')
    vetor_A = range(quantidade_A)
    quantidade_B = input('digite a quantidade de numeros do vetor B: ')
    vetor_B = range(quantidade_B)
    novo_vetor(vetor_A, vetor_B)

def novo_vetor(vetor_A,vetor_B):
    vetor_C = vetor_A + vetor_B
    print vetor_C
    inicio_vetor_D = len(vetor_C)/2-1
    vetor_D_D = inicio_vetor_D + 2
    vetor_D = vetor_C[inicio_vetor_D, vetor_D_D]
    print vetor_D
        
if __name__ == '__main__':
    main()
