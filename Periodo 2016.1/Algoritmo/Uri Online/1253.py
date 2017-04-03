def main():
    while True:
        try:
            N = input()
            for i in range(N):
                word = raw_input()
                posicion = input()
                cifra = ''
                for j in word:
                    if (j >= 'A' and j <= 'Z')  or (j >= 'a' and j <= 'z'):
                        if j >= 'a' and i <= 'z':
                            cif = (ord(j) - ord('a') - posicion) % 26
                            cifra += chr(cif + ord('a'))
                        else:
                            cif = (ord(j) - ord('A') - posicion) % 26
                            cifra += chr(cif + ord('A'))
                    else:
                        cifra += j
                print cifra
        except:
            break


if __name__ == '__main__':
    main()
                    
