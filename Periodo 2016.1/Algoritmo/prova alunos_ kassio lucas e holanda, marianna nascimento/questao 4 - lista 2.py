#-*- coding: utf-8 -*-

"""
Leia 2 (duas) notas parciais de um aluno, calcule a média e escreva a mensagem:
o "Aprovado", se a média alcançada for maior ou igual a sete;
o "Reprovado", se a média for menor do que sete;
o "Aprovado com Distinção", se a média for igual a dez.
"""

def main():
    nota1 = float(input('digite a primeira nota do aluno: '))
    nota2 = float(input('digite a segunda nota do aluno: '))
    notas(nota1, nota2)

def notas(nota1, nota2):
    soma = (nota1 + nota2) / 2
    if soma == 10:
        print'parabens, voce é um otimo aluno!!'
    elif soma >= 7:
        print'O aluno esta aprovado!!'

    else:
        print'voce esta reprovado, suas notas sao inferiores a 7!!'


if __name__=="__main__":
    main()