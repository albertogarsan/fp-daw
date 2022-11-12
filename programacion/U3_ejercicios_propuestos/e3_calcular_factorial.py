"""EJ-3 Realiza un programa que lea un número positivo N y calcule y visualice su factorial N!"""

"""
0! = 1
1! = 1
2! = 2 * 1
3! = 3 * 2* 1
N! = N * (N-1) * (N-2)........* 3*2*1
"""

while True:
    print("CALCULA UN FACTORIAL")
    
    user_num = int(input("Escribe un número positivo: "))
    factorial_num = 1
    
    if factorial_num != 0:
        for i in range(1, user_num+1):
            factorial_num = factorial_num * i
    print(f"Factorial: {factorial_num}") 
    
    respuesta = "z"
    while respuesta != "s" and respuesta != "n":
        respuesta = input("¿Quieres probar con otra número? (s / n): ")
        if respuesta != "s" and respuesta != "n":
            print("Por favor, selecciona una de las letras correctas.")
        
    if respuesta == "n":
        break
            
print("Programa terminado.")  
