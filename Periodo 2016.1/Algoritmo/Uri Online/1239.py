def main():
    while True:
        novo_texto = ''
        try:
            texto = raw_input()
            
            contador_1 = 0
            contador_2 = 0

            for palavras in texto:
                novo_texto += palavras   

                if palavras == '_' and contador_1 % 2 == 0:
                    contador_1+=1
                    novo_texto = novo_texto.replace('_','<i>')

                elif palavras == '_' and contador_1 % 2 != 0:
                    contador_1+=1
                    novo_texto = novo_texto.replace('_','</i>')

                elif palavras == '*' and contador_2 % 2 == 0:
                    contador_2+=1
                    novo_texto = novo_texto.replace('*','<b>')

                elif palavras == '*' and contador_2 % 2 != 0:
                    contador_2+=1
                    novo_texto = novo_texto.replace("*","</b>")
            
            print novo_texto
            
        except:
            break
            
if __name__ == '__main__':
    main()