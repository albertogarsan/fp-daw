#Modificar el area del rectangulo por la del cuadrado
# alberto_garcia_propuesto3.py
# Autor: Alberto Garcia Sánchez
# Data : 28/09/2022

import time

def areaRectangulo(base, altura):
    return base * altura

base = int(input("Dime la base del rectángulo: "))
altura = int(input("Dime la altura del rectángulo: "))

time.sleep(2) #espera 2 segundo
area = areaRectangulo(base, altura)
#mostramoa el resultado
print("El área del rectangulo es " + str(area))


def areaCuadrado(lado):
    return lado * lado 


lado=int(input("Dime el lado del cuadrado: "))
time.sleep(2) #Espera dos segundos
area=areaCuadrado(lado)
#mostramoa el resultado
print("El área del cuadrado es " + str(area))

