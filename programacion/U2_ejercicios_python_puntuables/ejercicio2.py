# alberto_garcia_ejercicio2.py

""" EJ - 2 

Implementar un programa que calcule la temperatura en grados Centígrados a partir de la temperatura en grados Fahrenheit.

La fórmula es la siguiente:

C = 5/9 *(F - 32)

Proceso a seguir:
 - Mostrar (por pantalla) el mensaje: “Pasar de grados Fahrenheit a Centígrados ...” 
 
 - Pedir al usuario los grados Fahrenheit que se quieren pasar a Centígrados 
 
 - Realizar el cálculo siguiendo la fórmula de la parte superior
 
 - Mostrar el resultado obtenido
 
 - Finalizar el programa con el mensaje: “Final” """
 
print("Bienvenidos al conversor de grados Fahrenheit a Centígrados en Python...")

gradosFarenheit = float(input("Introduce los grados Farenheit a convertir a Centígrados: "))

def convertirFarenheit(f):
    return 5 / 9 * (f - 32)

gradosCentigrados = convertirFarenheit(gradosFarenheit)

print("Este es el resultado en grados Centígrados: ", gradosCentigrados)
 
 
 