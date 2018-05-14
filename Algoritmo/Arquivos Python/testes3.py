"""
from math import sqrt, pow

def hipotenusa(b,c):
    return sqrt(pow(b,2) + pow(c,2))

def equacao():
    ladob = float(input("me diga o lado b"))
    ladoc = float(input("me diga o lado c"))
    print (hipotenusa(ladob,ladoc))

    
if __name__ == "__main__":
    equacao()
"""

from math import sqrt, pow

def funcao(a,b):
    return (sqrt(pow(b,15) + pow(a,-2)))

def funcao2():
    l_b= float(input("digite um numero para b: "))
    l_a= float(input("digite um numero para a: "))
    print (funcao(l_a,l_b))

if __name__=="__main__":
    funcao()
    
