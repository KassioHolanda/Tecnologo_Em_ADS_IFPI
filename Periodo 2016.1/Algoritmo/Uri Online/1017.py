#coding:utf-8

def main():
	tempo_viajem = float(input())
	velocidade_media = float(input())

	consumo = float((velocidade_media/12)*tempo_viajem)

	print'%.3f' % consumo

if __name__ == '__main__':
	main()