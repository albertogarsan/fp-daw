from time import sleep
from colorama import Fore, Style
from random import *
from operator import add, mul, sub

def numJugadores(participantes, listaNombres):
    #Numero partcipantes
    if participantes >= 1 and participantes <= 4:
        print("\n" + Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL)
        print(f"El número total de participantes es {participantes}")
        print(Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL + "\n")
        nomJugadores(participantes, listaNombres)
    else: 
        print("El num de jugadores no es correcto")  

def nomJugadores(participantes, listaNombres):
    #Nombre participantes 
    for i in range(1, participantes+1):
        nom = input(f"{Fore.GREEN}Dime el nombre del jugador {i}: {Style.RESET_ALL}")
        listaNombres.append(nom)
    print(f"\n{Fore.YELLOW}Jugadores guardados. \n")
    print(Fore.YELLOW + "ℹ️ Volviendo al menú...")
    sleep(1)

def jugar(participantes, listaNombres, dificultad):
    if participantes == 0:
        print(f"\n{Fore.RED}❌ Error, no has introducido ningún participante. ❌{Fore.RED}")
        print(Fore.YELLOW + "ℹ️  Volviendo al menú... \n")
        sleep(1)
    else:
        print("\n" + Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL)
        print(f"Empieza la partida...")
        print(Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL + "\n")
        sleep(1)
        turnos(participantes,listaNombres, dificultad)
           
def trivial(partcipantes, listaNombres):
    tipoPregunta = randint(1,2) 

    if tipoPregunta == 1:
        preguntaNum()
    elif tipoPregunta == 2:
        preguntaStr() 

def turnos(participantes, listaNombres, dificultad):
    turnos = 1
    
    if dificultad == 1:
        while turnos < 4:
            for i in range(1, participantes+1):
                print(f"{Fore.YELLOW}\nEl turno {turnos}, empieza el jugador: {Style.RESET_ALL}{listaNombres[i-1]}")
                trivial(participantes, listaNombres)
                if i == participantes:
                    turnos += 1
        print("\n" + Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL)
        print(f"Juego terminado, se pasarán los resultados.")
        print(Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL + "\n")
        sleep(1)
    elif dificultad == 2:
        while turnos < 7:
            for i in range(1, participantes+1):
                print(f"\nEl turno {turnos}, le toca al jugador: {listaNombres[i-1]}")
                trivial(participantes, listaNombres)
                if i == participantes:
                    turnos += 1
        print("\n" + Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL)
        print(f"Juego terminado, se pasarán los resultados.")
        print(Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL + "\n")
        sleep(1)
    elif dificultad == 3:
        while turnos < 10:
            for i in range(1, participantes+1):
                print(f"\nEl turno {turnos}, le toca al jugador: {listaNombres[i-1]}")
                trivial(participantes, listaNombres)
                if i == participantes:
                    turnos += 1
        print("\n" + Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL)
        print(f"Juego terminado, se pasarán los resultados.")
        print(Fore.BLUE + "+" + 40*"-" + "+" + Style.RESET_ALL + "\n")
        sleep(1)
                      
def preguntaNum():
    puntuacion = 0
    resultado = 0
    ecuacion1 = 0
    ecuacion2 = 0
    numero = []
    operador = []
    operacion = {}
    operadores = ["+","-","*"]

    for i in range(4):
        numero.append(randint(1,11)) #random entre 1 a 10
        operador.append(choice(operadores)) #añadir un random de esas opciones
        if operador[i] == "+":
            operacion[i] = add
        if operador[i] == "-":
            operacion[i] = sub
        if operador[i] == "*":
            operacion[i] = mul
    #formulas/ecuacion
    ecuacion1 = operacion[0](numero[0],numero[1])
    ecuacion2 = operacion[2](numero[2],numero[3])
    resultado = int(operacion[1](ecuacion1,ecuacion2))

    print(resultado)

    print(Fore.BLUE +"¿Cuánto es " + str(numero[0])+str(operador[0])+str(numero[1])+str(operador[1])+str(numero[2])+str(operador[2])+str(numero[3])+ "?" + Style.RESET_ALL)

    respuesta = int(input())
    if respuesta == resultado:
        print(f"{Fore.GREEN}Correcto {Style.RESET_ALL}")
        puntuacion = puntuacion + 1
    else:
        print(f"{Fore.RED}Incorrecto {Style.RESET_ALL}")
        print("Puntuacion =", puntuacion)
    
def preguntaStr():
    puntuacion = 0
    lista_palabras = ["casa", "programar", "python", "desarrollo web", "pasapalabra", "hormiga", "duvial"]
    
    #indice_palabra_random = randrange(len(lista_palabras)) #selecciono un numero entero de la lista preguntas_string: 0, 1 --> 0
    indice_palabra_random = randint(0, len(lista_palabras)-1)  # CAMBIADO

    palabra = lista_palabras[indice_palabra_random] #Capturamos la palabra que se va a preguntar --> programar
    #print(indice_palabra_random, palabra)

    longitud_palabra = len(palabra) #capturamos la longitud(indice) de la palabra que se va a pregunta --> 7 o 9 (letras)
    letras_a_ocultar = longitud_palabra // 3 #Dependiendo de la longitud de la palabra 4/3= 1

    #print(letras_a_ocultar)

    solucion_letra = []
    lista = list(palabra)
    posicion_letra_oculta = sample(range(len(lista)), letras_a_ocultar) #retorna varios elementos aleatorios de una lista sin repeticiones

    #print(posicion_letra_oculta)
    #print(lista)

    for i in range(letras_a_ocultar):
        solucion_letra.append(lista[posicion_letra_oculta[i]])
        lista[posicion_letra_oculta[i]] = "*" #Coge la posición aleatoria que puede ir desde 1 a la longitud de las palabra.
    #print(lista) #Como choice pero saca dos elementos o más de la lista sin que se repita, en esta caso de la cadena.
    x = "".join(lista)
    print(x)
    #print(solucion_letra)

    respuesta = input(f"{Fore.BLUE}¿Cúal es la palabra? {Style.RESET_ALL}")
        
    if respuesta == palabra:
        print(f"{Fore.GREEN}Correcto {Style.RESET_ALL}")
        puntuacion = puntuacion + 1
    else:
        print(f"{Fore.RED}Incorrecto {Style.RESET_ALL}")
        print("Puntuacion =", puntuacion)
               
def salir():
    while True:
        
        continuar = input("🫣\n¿No deseas volver a jugar? (" + Fore.GREEN +"s" + Style.RESET_ALL+"/" + Fore.RED+"n" + Style.RESET_ALL + "): ").lower()
        
        if continuar != "s" and continuar != "n":
            print("Selecciona una respuesta correcta: s/n", end=" ")
            
        if continuar == "n":
            print(Fore.YELLOW +40*"-")
            print("Finalizando...")
            sleep(1)
            print(40*"-")
            print("...Gracias por jugar ¡Hasta pronto! \n")
            exit()
            
        if continuar == "s":
            sleep(1)
            print(Fore.LIGHTBLUE_EX + "\n¡Volviendo a jugar! \n")
            print(Style.RESET_ALL,end="")
