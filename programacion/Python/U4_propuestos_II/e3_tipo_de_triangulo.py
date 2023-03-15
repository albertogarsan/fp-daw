""" 
EJ - 3 

Modifica el programa anterior para que incluya la función tipoTriangulo que, a partir de las longitudes de los lados, retorne el tipo de triángulo: equilátero, isósceles o escaleno. O bien, ”error” si los datos no se corresponden con un triángulo (utiliza la función realizada en el punto anterior esTriangulo). 

"""

import funciones 

x = int(input("Introduce un lado de un triangulo: "))
y = int(input("Introduce un lado de un triangulo: "))
z = int(input("Introduce un lado de un triangulo: "))

valor = funciones.esTriangulo(x, y, z) #retorna true or false

if valor == True:
    funciones.tipoTriangulo(x, y, z)
else:
    print("ERROR FATAL")