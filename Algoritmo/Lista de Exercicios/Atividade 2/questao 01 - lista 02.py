def numeros(num1,num2,num3):
	if num1 == num2 == num3:
		print "todos os numeros sao iguais"
	elif num1 == num2 or num2 == num3 or num1 == num3:
		print "apenas dois numeros sao iguais"
	else:
		print"os numeros nao sao iguais"
			

def main():
	num1 = float(input("digite um valor para o primeiro numero: "))
	num2 = float(input("digite um valor para o segundo numero: "))
	num3 = float(input("digite um valor para o terceiro numero: "))
	numeros(num1,num2,num3)


if __name__ == '__main__':
	main()


