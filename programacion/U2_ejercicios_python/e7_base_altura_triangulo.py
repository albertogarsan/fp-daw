# alberto_garcia_propuesto7.py
#Ejercicio propuesto 7 - Programa que pregunte por la base y la altura de un triángulo y muestre por pantalla el área de ese triángulo. 

def areaTriangulo(base, altura):
    return base * altura / 2

base = int(input("Dime la base del triangulo: "))
altura = int(input("Dime la altura del triangulo: "))

areaTriangulo = areaTriangulo(base, altura)

print("El area del triangulo es ", areaTriangulo)