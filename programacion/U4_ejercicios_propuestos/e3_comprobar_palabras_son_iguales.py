""" 
Ejercicio 3 

Programa para comparar si dos palabras, introducidas por el usuario, son iguales. 

Como resultado mostrará:
1) Si las palabras son exactamente iguales
2) Si las palabras son iguales (sin tener en cuenta mayúsculas y minúsculas)
3) O si las palabras son totalmente diferentes 

"""

print("Comparador de palabras")

cadena1 = str(input("Escribe una palabra: "))
cadena2 = str(input("Escribe otra palabra: "))

#Comprobamos si son estrictamente iguales
if cadena1 == cadena2:
    print(True)

#Asignamos a una nueva variable que la string la pase a minusculas
cadena_lower1 = cadena1.lower()
cadena_lower2 = cadena2.lower()

#Tras pasarlas a minusculas, volver a comprobar si son estrictamente iguales
if cadena_lower1 == cadena_lower2:
    print(True)
else:
    print("Son palabras totalmente diferentes")
    
    
    



