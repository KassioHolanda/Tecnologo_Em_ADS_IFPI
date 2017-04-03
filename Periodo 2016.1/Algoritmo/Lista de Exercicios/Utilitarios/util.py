
def has_no_e(palavra):
	return 'e' not in palavra.lower()


def has_no_e2(palavra):
	qtd_de_e = palavra.lower().count('e')
	if qtd_de_e > 0:
		return True
	return False


def avoids(palavra, letras_proibidas):
	for letra in letras_proibidas.lower:
		if letra in palavra.lower:
			return False
	
	return True


def uses_only(palavra, letras_obrigatorias):
	for letra in letras_obrigatorias:
		if letra not in letras_obrigatorias:
			return False

	return True

def uses_all(palavra, letras_obrigatorias):
	for letra in letras_obrigatorias.lower():
		if letra not in palavra.lower():
			return False
	return True


def is_abecedarian(palavra):
	index = 0
	while index < len(palavra) - 1:
		if palavra[index] < palavra[index + 1]:
			return False

		index += 1
	return True