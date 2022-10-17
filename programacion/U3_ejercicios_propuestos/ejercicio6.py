""" EJ - 6 Hacer un programa que pida dos parámetros, un número 𝑛 y un carácter cualquiera 𝑐 (*, &, @ o una letra). Dependiendo de las opciones pintará un cuadrado de lado n con el carácter c. """

""" 
EJEMPLO

EJECUCIÓN 1
Parámetros: 6ñ
Resultado :
            ññññññ
            ññññññ
            ññññññ
            ññññññ
            ññññññ
            ññññññ
EJECUCIÓN 2
Parámetros: 4*
Resultado : ****
            ****
            **** 
            **** 
"""
            
n = int(input("Introduce un número: "))
c = input("Introduce cualquier caracter: ")

print(f"Parámetros: {n}{c}")
print("Resultado: ", end="")

for i in range(1,n+1):
    for i in range(1,n+1):   
        print(c, end="")
    print()
    





    
    
    