#-*- coding utf-8 -*-

#Leia uma data no formato DD/MM/AAAA e escreva o mês por extenso (DD de mês de AAAA).

def main():
        digite_data = raw_input('digite uma da data(exemplo: DD/MM/AAAA): ' )
        data(digite_data)

def data(digite_data):
        if digite_data[3:5] == '01':
                a = 'janeiro'
        if digite_data[3:5] == '02':
                a = 'fevereiro'
        if digite_data[3:5] == '03':
                a = 'mar�o'
        if digite_data[3:5] == '04':
                a = 'abril'
        if digite_data[3:5] == '05':
                a = 'maio'
        if digite_data[3:5] == '06':
                a = 'junho'
        if digite_data[3:5] == '07':
                a = 'julho'
        if digite_data[3:5] == '08':
                a = 'agosto'
        if digite_data[3:5] == '09':
                a = 'setembro'
        if digite_data[3:5] == '10':
                a = 'outubro'
        if digite_data[3:5] == '11':
                a = 'novembro'
        if digite_data[3:5] == '12':
                a = 'dezembro'


        print ' a data digitada foi de %s de %s de %s' % (digite_data[0:2], a, digite_data[6:10])

        
if __name__=='__main__':
        main()
