def main():
    print "\n\nmain"
    resultado = 0
    existentes = [5,2,3,1]
    disponiveis = [3,1,1,0]

    alocados = [
        [0,0,1,0],
        [1,0,0,0],
        [1,1,1,1],
        [0,0,0,0]
    ]

    # 4 2 2 1
    # 4 2 3 1
    # 5 2 3 1

    requisitados = [
        [1,0,0,0],
        [1,1,2,0],
        [0,0,0,0],
        [1,1,1,0]
    ]

    consultar_matrizes(existentes, disponiveis, alocados, resultado, requisitados)

def consultar_matrizes(existentes, disponiveis, alocados, resultado, requisitados):
    print "\n\nConsultar matrizes"

    for i in range(len(disponiveis)):
        for j in range(len(disponiveis)):
            if requisitados[i][0] <= disponiveis[0] and requisitados[i][1] <= disponiveis[1] \
                    and requisitados[i][2] <= disponiveis[2] and requisitados[i][3] <= disponiveis[3]:
                disponiveis[0] += alocados[i][0]
                disponiveis[1] += alocados[i][1]
                disponiveis[2] += alocados[i][2]
                disponiveis[3] += alocados[i][3]
                resultado += 1
                break
    consultar_deadlock(existentes, disponiveis, resultado)

def consultar_deadlock(existentes, disponiveis, resultado):

    print "\n\nConsultar deadlock"
    print disponiveis[0] == existentes[0]
    print disponiveis[1] == existentes[1]
    print disponiveis[2] == existentes[2]
    print disponiveis[3] == existentes[3]

    if resultado == 4 and disponiveis[0] == existentes[0] and disponiveis[1] == existentes[1] and disponiveis[2] == existentes[2] and disponiveis[3] == existentes[3]:
        print "\n"
        print "Sem DeadLock"
    else:
        print "\n"
        print "DeadLock"

if __name__ == "__main__":
    main()