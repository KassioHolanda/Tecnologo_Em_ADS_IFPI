#-*- coding: utf-8 -*-

"""
Em uma eleição presidencial existem 3 (três) candidatos. Os votos são informados através de códigos.
Os dados utilizados para a contagem dos votos obedecem à seguinte codificação:
· 1, 2, 3 = voto para os respectivos candidatos;
· 9 = voto nulo;
· 0 = voto em branco;
Escreva um algoritmo que leia o código votado por N eleitores. Ao final, calcule e escreva:
a) total de votos para cada candidato;
b) total de votos nulos;
c) total de votos em branco;
d) quem venceu a eleição.
"""


def main():
    candidato = 0
    cand1 = 0
    cand2 = 0
    cand3 = 0
    nulo = 0
    branco = 0
    resultado = 0
    print "digite o numero de acordo com suas intenções de voto..."
    print"digite 1 para o primeiro candidato, 2 para o segundo candidato, 3 para o terceiro candidoto, 0 para voto em branco, 9 para voto nulo e para cancelar digite 4 "
    voto = input("digite o numero relacionado ao seu voto: ")
    while voto != 4:
        if voto == 1 or voto == 2 or voto == 3 or voto == 9 or voto == 0:
            candidato += 1
            if voto == 1:
                cand1 += 1
            if voto == 2:
                cand2 += 1
            if voto == 3:
                cand3 += 1
            if voto == 0:
                branco += 1
            if voto == 9:
                nulo += 1
        voto = input("digite o numero relacionado ao seu voto: ")

    if cand1 > cand2 and cand1 > cand3 and cand1 > nulo and cand1 > branco:
        resultado = cand1
    if cand2 > cand1 and cand2 > cand3 and cand2 > nulo and cand2 > branco:
        resultado = cand2
    if cand3 > cand2 and cand3 > cand1 and cand3 > nulo and cand3 > branco:
        resultado = cand3


    print ('o tatal de votos foi do candidato 1 foi %d' % cand1)
    print ('o tatal de votos foi do candidato 2 foi %d' % cand2)
    print ('o tatal de votos foi do candidato 3 foi %d' % cand3)
    print ('o total de votos nulos foi de %d' % nulo)
    print ('o total de votos em branco foi de %d' % branco)
    print ('o campeao das eleições foi o candidato %d' % resultado)

if __name__ =="__main__":
    main()