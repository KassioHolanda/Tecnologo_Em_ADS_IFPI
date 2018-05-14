def tabuada(num,x):
        if x > 10:
                print "FIM"
        else:
                resultado = num * x
                print "%i x %i = %i" %(num,x,resultado)
                tabuada(num, x + 1)
def main():
        num = int(input('digite o numero a ser multiplicado: '))
        tabuada(num,1)
        
if __name__ == '__main__':
        main()


