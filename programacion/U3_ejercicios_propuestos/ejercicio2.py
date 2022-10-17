"""EJ - 2 Realiza un programa para mostrar todas las tablas de multiplicar que quiera el usuario. Para
ello, se pedirá cada número para mostrar su tabla y se preguntará al usuario si quiere continuar. El
programa finalizará cuando el usuario conteste que no quiere seguir (n o N)"""

"""TABLAS DE MULTIPLICAR
Tabla del número: 5
5x1=5 5x2=10 5x3=15 5x4=20 5x5=25 5x6=30 5x7=35 5x8=40 5x9=45
5x10=50
Quieres continuar?(s/n): s
Tabla del número: 2
2x1=2 2x2=4 2x3=6 2x4=8 2x5=10 2x6=12 2x7=14 2x8=16 2x9=18 2
x10=20
Quieres continuar?(s/n): n"""

while True:
    print("TABLAS DE MULTIPLICAR")
    
    tabla_multiplicar = int(input("Elige una tabla de multiplicar: "))
    
    def multiplicar(numero_a_multiplicar):
        for i in range(1, 11):
            resultado = numero_a_multiplicar * i
            print(f"{numero_a_multiplicar}x{i}={resultado}", end="  ")
             
    multiplicar(tabla_multiplicar)
    print(" ")
    
    #Preguntar al usuario si quiere continuar o finalizar el programa.
    respuesta = "z" #inicializamos con un valor incorrecto para entrar en el bucle
    while respuesta != "s" and respuesta != "n": #true
        respuesta = input("¿Quieres probar con otra tabla? (s / n): ")
        if respuesta != "s" and respuesta != "n": 
            print("Por favor, selecciona una de las letras correctas.")
        
    if respuesta == "n":
        break
    
print("Programa finalizado. ¡Adiós!")
    