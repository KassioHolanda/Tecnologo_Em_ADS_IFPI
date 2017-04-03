#-*- coding: utf-8 -*-


'''
Em 1939, Ernest Vincent Wright publicou um 50.000 palavra romance chamado Gadsby que
não contém a letra "e". Desde "e" é a letra mais comum em Inglês, isso não é fácil de fazer.
De facto, é difícil construir um pensamento solitário sem usar esse símbolo mais comum. Isto é
lento no início, mas com cautela e horas de treinamento você pode gradualmente ganhar instalações.
Tudo bem, eu vou parar agora.
Escrever uma função chamada has_no_e que retorna True se a palavra dada não tem a letra "e" nela.
Modificar o programa da seção anterior para imprimir apenas as palavras que não têm "e" e calcular a percentagem das palavras na lista que não têm "e".
'''

def main():
        cont = 0
        cont_t = 0
        
        arquivo = open('words.txt')
        for letra in arquivo:
                palavra = letra.strip()
                if palavra.find('e') == -1:
                        print palavra
                        cont = cont + 1
                        cont_t = cont_t + 1
                else:
                        cont_t = cont_t + 1
                        #print cont_t


        porcentagem = (cont*100)/cont_t
        print 'a porcentagem de palavras que nao contem a letra (e) é de: %2.f %%' % porcentagem



if __name__ == '__main__':
        main()
