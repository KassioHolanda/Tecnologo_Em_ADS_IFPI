def main():
    while True:
        try:
            frase = raw_input()
            rot13 = ''

            for letra in frase:
                if (letra >= 'A' and letra <= 'Z') or (letra >= 'a' and letra <= 'z'):
                    if letra >= 'a' and letra <= 'z':
                        mudanca = (ord(letra) - ord('a') + 13) % 26
                        rot13 += chr(mudanca + ord('a'))
                    else:
                        mudanca = (ord(letra) - ord('A') + 13) % 26
                        rot13 += chr(mudanca + ord('A'))
                else:
                    rot13 += letra
            
            print rot13
        
        except:
            break

if __name__ == '__main__':
    main()