# alberto_garcia_ejercicio3.py

""" EJ - 3 

Implementar un programa que calcule los intereses producidos y el capital acumulado de una cantidad c invertida a un interés r  (expresado en tanto por ciento) durante t días. 

La fórmula para el cálculo de intereses es:
Y = c * r * t / 360 * 100 

Debes comprobar que si invertimos 10000 euros a un 3,5 % de interés durante un año, tendremos un total de 10350.

Proceso a seguir:
    - Mostrar (por pantalla) el mensaje: “Calcular intereses ...” 
    
    - Pedir al usuario la información necesaria

    - Realizar el cálculo siguiendo la fórmula de la parte superior 
    
    - Mostrar el resultado obtenido

    - Finalizar el programa con el mensaje: “Final” 

Realizar la ejecución del programa al menos 2 veces:

    - Una donde utilices los valores de la comprobación 
    
    - Otra para los valores que quieras utilizar
"""

print("Calcular intereses... ")

c = int(input("Introduce el capital acumulado durante este año: "))
#r = 3.5
#t = 360
r = float(input("Introduce el % de interés: "))
t = int(input("Introduce los años: "))
t = t * 365

def calcularIntereses(c):
    return (c * r * t) / (360 * 100)

intereses = round(calcularIntereses(c))

resultado = str(c + intereses) 

print(f"Este es el resultado de la inversión obtenido con un 3.5%: {resultado}€")