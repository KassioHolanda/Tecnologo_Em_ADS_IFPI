def lista(cont_idade, cont_regular, cont_bom, cont_otimo, pessoas):
        idade = int(input('Digite a idade: '))
        opiniao = int(input('Opiniao (1- otimo / 2- bom/ 3-regular/ 4- pessimo): '))
        while idade >= 1:
            pessoas += 1
            if opiniao == 1:
                cont_idade += idade
                cont_otimo += 1

            if opiniao == 3:
                cont_regular += 1

            if opiniao == 2:
                cont_bom += 1

            idade = int(input('Digite a idade: '))
            opiniao = int(input('Opiniao (1- otimo / 2- bom/ 3-regular/ 4- pessimo): '))

        media_idade = float(cont_idade / cont_otimo)
        perc_bom = float((100 * cont_bom) / pessoas)

        print('A média das idades das pessoas que escolheram 1 - ÓTIMO: %.2f ' % media_idade)
        print('%d pessoas responderam 3- REGULAR' % cont_regular)
        print('%d/100 das pessoas responderam 2- BOM.' % perc_bom)




lista(0,0,0,0,0)