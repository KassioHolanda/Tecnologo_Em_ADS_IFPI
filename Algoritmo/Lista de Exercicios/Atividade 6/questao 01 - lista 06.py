e#-*- coding: utf-8 -*-

'''
Faça a criptografia de uma frase digitada pelo usuário. Na criptografia, a frase deverá ser invertida e as
consoantes deverão ser substituídas pelo caractere #.
'''

def main():
        frase = raw_input('digite uma frase: ')
        frase_inversa = frase[::-1]
        for letra in frase_inversa.split():
                if letra != 'a' and letra != 'e' and letra != 'i' and letra != 'o' and letra != 'u':
                        print letra.split().replace(letra,'#')

                        

        
if __name__ == '__main__':
        main()
