# Programa que calcula el área de un rectangulo
# alberto_garcia_propuesto2.py
# Autor: Alberto Garcia Sánchez
# Data : 28/09/2022

import time #Con impot indicamos que necesitamos una libreria. La función que utilizaremos es time.sleep() que hace que el programa se pause una cantidad de segundos.

def areaRectangulo(base, altura): #definición de una función empieza con la palabra reservada def + nombre de la función (param1, param2)
    return base * altura
base = int(input("Dime la base del rectángulo: "))
altura = int(input("Dime la altura del rectángulo: "))

time.sleep(2) #espera 2 segundo
area = areaRectangulo(base, altura)

print("El área del rectangulo es " + str(area))

