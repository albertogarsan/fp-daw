#Elabora una calculadora con el siguiente menu:
"""
Bienvenido a tu calculadora
   1. Suma
   2. Resta
   3. Salir
Ingrese una opción:
"""
#Pedir al usuario que opción desea usar sea 1 para suma, 2 para resta o 3 para salir.
#Si el usuario ingresa 1 o 2, pida dos número y realice la operación. 
#El programa deberá seguir mostrando el menú hasta que el usuario coloque la opción 3.
from colorama import Fore, Style

opcion = ""    
while opcion != 3:
    #Menu
    print(40*"-")
    print("Bienvenido a tu calculadora".center(40, " ").upper())
    print(40*"-")
    print("\n1. Suma")
    print("2. Resta")
    print("3. Salir\n")
    opcion = int(input("Ingresa una opción: "))
    print(Style.RESET_ALL,end="")
    
    #Condicions
    if opcion == 1:
        valor1=int(input("Ingresa un valor para la suma: "))
        valor2=int(input("Ingresa otro valor para la suma: "))
        resultado = valor1 + valor2
        print(Fore.GREEN+f"\n Este es el resultado de la suma: {resultado} \n")
        print(Style.RESET_ALL,end="")
    elif opcion == 2:
        valor1=int(input("Ingresa un valor para la resta: "))
        valor2=int(input("Ingresa otro valor para la resta: "))
        resultado = valor1 - valor2
        print(Fore.GREEN+f"\n Este es el resultado de la resta: {resultado} \n")
        print(Style.RESET_ALL,end="")
    elif opcion == 3:
        print("Gracias por usar la calculadora!")
    else:
        print(Fore.RED+"\n Ingrese una opción válida. \n")
        print(Style.RESET_ALL,end="")

