#_*_ coding: utf-8 _*_
#Insira os pontos assim --> x1,x2
import math

print "Insira os pontos assim --> x1,x2"
ponto1=raw_input().split(",")
x1=int(ponto1[0])
y1=int(ponto1[1])

ponto2=raw_input().split(",")
x2=int(ponto2[0])
y2=int(ponto2[1])

distancia=math.sqrt((x2-x1)**2+(y2-y1)**2)

print "Distancia = %.4f" % (distancia)