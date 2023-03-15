from time import sleep
from colorama import Fore, Style
from libreria import *

print(Fore.BLUE + "+" + 40*"-" + "+")
print("EL JUEGO DE DUVIAL".center(40, " "))
print("+" + 40*"-" + "+ \n")
print(Style.RESET_ALL,end="") 
print("Bienvenido/as al juego de preguntas \ny respuestas inspirado en el conocido juego del Trivial. \n")

listaNombres = []
participantes = 0
dificultad = 1
opcion = "" 
   
while opcion != 4:
    #Menu
    print(Fore.BLUE + "+" + 40*"-" + "+")
    print("MENU".center(40, " "))
    print("+" + 40*"-" + "+ \n")
    print(Style.RESET_ALL,end="") 
    print("1. Jugadores")
    print("2. Dificultad")
    print("3. Jugar partida")
    print("4. Salir \n")
    opcion = int(input(Fore.GREEN + "Ingresa una opción: " + Style.RESET_ALL))
    if opcion==1:
        participantes = int(input(f"{Fore.GREEN}Introduce el numero de participantes: {Style.RESET_ALL}"))
        numJugadores(participantes, listaNombres)
    if opcion==2:
        dificultad = int(input(f"{Fore.GREEN}Has elegido 'Dificultad', elige dificultad 1, 2 o 3: {Style.RESET_ALL}"))
        print(f"\n{Fore.YELLOW}Has elegido la dificutad {dificultad} {Style.RESET_ALL} \n")
        print(Fore.YELLOW + "ℹ️ Volviendo al menú...")
        sleep(1)
        while dificultad > 3 or dificultad < 1:
            if dificultad > 3 or dificultad < 1:
                dificultad = int(input("Vuelve a seleccionar la dificultad, ¿1, 2 o 3?: "))     
    if opcion==3:
        jugar(participantes, listaNombres, dificultad)
    if opcion==4:
        salir()


    