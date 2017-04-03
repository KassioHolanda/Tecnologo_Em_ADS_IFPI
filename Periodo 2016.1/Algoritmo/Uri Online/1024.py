def main():
    N = input()
    for i in range(N):
        contador = 0
        criptografia = ''
        nova_criptografia = ''
        frase = raw_input()
        for letra in frase:
            if letra == '':
                criptografia += letra
            elif (ord(letra) >= 65 and ord(letra) <= 90) or (ord(letra) >= 97 and ord(letra) <= 122):
                criptografia = criptografia + (chr(ord(letra) + 3))
            else:
                criptografia = criptografia + letra       
        n_cript = criptografia[::-1]
        for letra in n_cript:
            if contador >= len(criptografia)/2:
                nova_criptografia = nova_criptografia + chr(ord(letra)-1)
                contador += 1
            else:
                nova_criptografia = nova_criptografia + letra
                contador += 1
        
        print nova_criptografia

if __name__ == '__main__':
    main()

