""" EJ - 2 

Programa para validar si 3 valores para cada lado podrían formar un triángulo. Se validará con la función esTriangulo que, a partir de 3 valores enteros, retornará un booleano diciendo si esos valores se pueden corresponder con las longitudes de un triángulo o no.

Nota: 3 valores formarán triángulo si el valor que corresponde a cada lado es menor que la suma de los otros dos valores (lados).
 
"""

#import funciones

""" def esTriangulo(a, b, c):
    if a > (b + c):
        resultado = False
        print(resultado)
    elif b > (a + c):
        print(f"2-{b} es mayor que {a+c}, no es un triángulo válido")
    elif c > (a + b):
        print(f"3 - {c} es mayor que {a+b}, no es triangulo valido.")
    else:
        print("es un triangulo valido")

x = int(input("Introduce un lado de un triangulo: "))
y = int(input("Introduce un lado de un triangulo: "))
z = int(input("Introduce un lado de un triangulo: "))

esTriangulo(x, y, z) """


import funciones 

x = int(input("Introduce un lado de un triangulo: "))
y = int(input("Introduce un lado de un triangulo: "))
z = int(input("Introduce un lado de un triangulo: "))

print(funciones.esTriangulo(x, y, z))

