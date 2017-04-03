def main():
    novo_vetor = []
    vetor = []
    while True:
        N = input()
        if N == 0:
            ultimo = len(novo_vetor) - 1
            del novo_vetor[ultimo]
            ultimo = len(novo_vetor) - 1
            del novo_vetor[ultimo]
            for i in novo_vetor:
                print i
            break
        else:
            vetor = []
            for i in range(N):
                nome = raw_input()
                vetor.append(nome.upper())
            maior = max(len(i) for i in vetor)
            for i in vetor:
                j = str(i)
                novo_vetor.append((j.rjust(maior)))
            novo_vetor.append('')
            novo_vetor.append('')

if __name__ == '__main__':
    main()

