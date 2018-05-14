def numeros (num1,num2,num3,num4,num5):
	if num1 % 2 == 0 and num2 % 2 == 0 and num3 % 2 == 0 and num4 % 2 == 0 and num5 % 2 == 0:
		print "todos os valores sao pares"
	elif num1 % 2 ==0 and num2 % 2 == 0 and num3 % 2 == 0 and num4 % 2 == 0 or num5 % 2 ==0 and num2 % 2 == 0 and num3 % 2 == 0 and num4 % 2 or num1 % 2 ==0 and num2 % 2 == 0 and num3 % 2 == 0 and num5 % 2 == 0:
		print "apenas quatro valores sao iguais"
	elif num1 % 2 == 0 and num2 % 2 == 0 and num3 % 2 == 0 or num1 % 2 == 0 and num2 % 2 == 0 and num4 % 2 == 0 or num1 % 2 ==0 and num2 % 2 == 0 and num5 % 2 == 0 or num3 % 2 == 0 and num4 % 2 == 0 and num5 % 2 == 0 or num3 % 2 == 0 and num4 % 2 == 0 and num1 % 2 == 0 or num3 % 2 ==0 and num1 % 2 == 0 and num5 % 2 == 0:
		print "apenas tres valores sao iguais"
	elif num2 % 2 == 0 and num3 % 2 == 0 or num2 % 2 == 0 and num4 % 2 == 0 or num2 % 2 == 0 and num5 % 2 == 0 or num2 % 2 ==0 and num4 % 2==0 or num3 % 2 == 0 and num4 % 2 == 0 or num3 % 2 == 0 and num5 % 2 == 0 or num1 % 2 == 0 and num2 % 2 == 0 or num1 % 2 == 0 and num3 % 2 == 0 or num1 % 2 == 0 and num4 % 2 == 0 or num1 % 2 == 0 and num5 % 2 == 0 or num4 % 2 == 0 and num5 % 2 == 0:
		print "apenas dois valores sao iguais"
	if num1 % 2 == 0 or num2 % 2 == 0 or num3 % 2 == 0 or num3 % 2 == 0 or num5 % 2 == 0:
		print "apenas um valor e par."	
	else:
		print "nenhum valor e par"



def main():
	num1 = int(input("digite um numero inteiro: "))
	num2 = int(input("digite um numero inteiro: "))
	num3 = int(input("digite um numero inteiro: "))
	num4 = int(input("digite um numero inteiro: "))
	num5 = int(input("digite um numero inteiro: "))
	numeros(num1,num2,num3,num4,num5)

if __name__ == '__main__':
	main()