# alberto_garcia_ejercicio4.py

""" EJ - 4 

Realizar un programa para calcular los polinomios que sigan este patrón: 

ax**5 - bx**3 + cx - d

En cada ejecución, los valores de a, b, c, d se introducen por el teclado para realizar los cálculos de un polinomio concreto.

Proceso a seguir:
    - Mostrar (por pantalla) el mensaje: “Polinomios de grado 5 ...”

    - Pedir al usuario los valores enteros de a, b, c y d
    
    - Mostrar por pantalla cuál es el polinomio resultante con los valores introducidos 
    
    - Obtén el resultado del polinomio para el valor de x=-10 
     
    - Obtén el resultado del polinomio para el valor de x=-1 
    
    - Obtén el resultado del polinomio para el valor de x=0  
    
    - Obtén el resultado del polinomio para el valor de x=1 
    
    - Obtén el resultado del polinomio para el valor de x=10  
    
    - Mostrar para cada valor de x qué resultado se ha obtenido
    
    - Finalizar el programa con el mensaje: “Final” 
    
    """
    
    
print("Vamos a calcular los polinomios de grado 5...")

a = int(input("Introduce un valor para a: "))

b = int(input("Introduce un valor para b: "))

c = int(input("Introduce un valor para c: "))

d = int(input("Introduce un valor para d: "))


print("Este es el polinomio resultante: a*x^5 - b*x^3 + c*x - d")

""" 
x = -10
print("El resultado para el valor de x = -10 es: ", a*x**5 - b*x**3 + c*x - d)
x = -1
print("El resultado para el valor de x = -1 es: ", a*x**5 - b*x**3 + c*x - d)
x = 0
print("El resultado para el valor de x = 0 es: ", a*x**5 - b*x**3 + c*x - d)
x = 1
print("El resultado para el valor de x = 1 es: ", a*x**5 - b*x**3 + c*x - d)
x = 10
print("El resultado para el valor de x = 10 es: ", a*x**5 - b*x**3 + c*x - d)   """

def polinomio(x):
    return a*x**5 - b*x**3 + c*x - d

print("El resultado para el valor de x = -10 es: ", polinomio(-10))
print("El resultado para el valor de x = -10 es: ", polinomio(-1))
print("El resultado para el valor de x = -10 es: ", polinomio(0))
print("El resultado para el valor de x = -10 es: ", polinomio(1))
print("El resultado para el valor de x = -10 es: ", polinomio(10))

print("Final")