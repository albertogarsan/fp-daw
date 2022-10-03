# alberto_garcia_propuesto10.py
# Ejercicio propuesto 10 - A partir del listado de números que tienes a continuación, imprimirlos ordenados por el punto decimal y con dos decimales. 

numeros = [23.453, 2.324, 154, 23142.253, 53.0000343]
numeros.sort()

print("%2.2f" %numeros[0] , "%2.2f" %numeros[1], "%2.2f" %numeros[2], "%2.2f" %numeros[3], "%2.2f" %numeros[4]) 
