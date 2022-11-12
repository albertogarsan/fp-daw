"""
EJ - 3 Haz un programa para realizar el cálculo de diferentes series numéricas. Al iniciarse el programa mostrará un menú donde el usuario elegirá qué quiere hacer:

MENU
1- Progresión geométrica
2- Serie de Fibonacci
Selecciona la opción:

1- Si el usuario elige la opción 1, se pedirá el número inicial, la cantidad de términos que se quieren mostrar y la razón (cantidad a multiplicar)

Disponéis en este enlace del funcionamiento de las progresiones geométricas (PG) 

Ejemplo de Progresión Geométrica:
2, 4, 8, 16, 32 ... (núm_inicial= 2, r(razón)= 2, términos= 5)

"""

print("MENU")
print("1- Progresión geométrica")
print("2- Serie de Fibonacci")

opcion = 0

while opcion != 1 and opcion != 2:
    
    opcion = int(input("Selecciona una opción: "))
    
    if opcion != 1 and opcion != 2:
        print("Por favor, seleccione 1 para la progresión geométrica o 2 para la serie de Fibonacci.")

    if opcion == 1:
        num_inicial = int(input("Número inicial: "))
        terminos = int(input("Cantidad de términos a mostrar: "))
        razon = int(input("Cantidad a multiplicar: "))
        
        for i in range(num_inicial, terminos+1):
            resultado = num_inicial = num_inicial * razon 
            print(resultado)
    elif opcion == 2:
        terminos = int(input("Cantidad de términos: "))
        
        
            
                
            
            
            
        
        
            
            
