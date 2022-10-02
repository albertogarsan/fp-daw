# Programa que calcula el área de un rectangulo
# Autor: Alberto Garcia Sánchez
# Data : 28/09/2022

import time

def areaRectangulo(base, altura):
    return base * altura
base = int(input("Dime la base del rectángulo: "))
altura = int(input("Dime la altura del rectángulo: "))

time.sleep(2) #espera 2 segundo
area = areaRectangulo(base, altura)

print("El área del rectangulo es " + str(area))

