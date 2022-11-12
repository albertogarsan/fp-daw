""" EJ - 8 Haz un programa para mostrar una Progresión aritmética (PA) preguntando el número de términos, la cantidad a sumar o restar (d=desplazamiento), el número inicial y si es creciente (C) o decreciente (D). Calcula la suma de todos los términos. """

""" 
EJEMPLO

PROGRESIÓN ARITMÉTICA
Número de términos: 5
Desplazamiento: 2
Número inicial: 2
Creciente(C) o Decreciente(d)?: C
PA= 2, 4, 6, 8, 10
"""

print("PROGRESIÓN ARITMÉTICA")

t = int(input("Número de términos: "))
d = int(input("Desplazamiento: "))
i = int(input("Número inicial: "))
c = input("Creciente(c) o Decreciente(d)?: ")
PA = 2, 4, 6, 8, 10

if c == "d":
    for n in range(t):
        print(i*n-d)
    
    while c != "c" and c != "d":
        c = input('Escribe "c" o escribe "d" para que sea válido: ')
    if c != "c" and c != "d":
        print("No quieres colaborar! Jaja")
elif c == "c":
    for n in range(t):
        print(i*n+d)
        

