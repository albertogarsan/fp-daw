"""
EJ - 2 Programa que haga una quiniela de manera aleatoria (busca en Internet cómo encontrar números aleatorios en Python). El programa deberá mostrar qué símbolo ponemos en cada una de las 15 posiciones (1, X o 2) y continuará creando quinielas hasta que el usuario quiera salir.
    
Posición  1: X
Posición  2: 2
...
Posición 15: 1

"""
import random

resultados = ("1", "X", "2")
quiniela = 1

while True: 
    print(f"Quiniela {quiniela}")
    
    for i in range(1, 16):
        print(f"Posición {i}: {random.choice(resultados)}")
        
    quiniela += 1
    
    respuesta = "z"
    while respuesta != "s" and respuesta != "n":
        respuesta = input("¿Crear otra quiniela? (s / n): ")
        if respuesta != "s" and respuesta != "n":
            print("Por favor, selecciona una de las letras correctas.")
        
    if respuesta == "n":
        print("¡Hasta pronto!")
        break




    