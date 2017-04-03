def verifica_data (dia, mes, ano):
	if dia > 0 and mes <=12:
		if mes > 0 and mes <=12:
			if ano > 0:
				return "data valida"
	return "data invalida"

def main():
	print "programa verifica data valida"
	dia = int(raw_input("digite o dia: "))
	mes = int(raw_input("digite o mes: "))
	ano = int(raw_input("digite o ano: "))

	resultado = verifica_data(dia, mes, ano)
	print resultado

def name():
	print "kassio"

if __name__ == "__main__":
	name()
	main()