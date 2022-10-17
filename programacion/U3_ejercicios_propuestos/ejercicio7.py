""" 
EJ-7 Haz un programa que calcule las soluciones reales de la ecuación de 2o grado 𝑎𝑥2+𝑏𝑥+𝑐= √
 0, cuya fórmula es 𝑥 = −𝑏± 𝑏2−4𝑎𝑐 2𝑎
 
Hay que comprobar si tiene solución (lo que está dentro de la raíz debe ser positivo) y la fórmula no es valida cuando a = 0. """
""" 
EJEMPLO:
    
ECUACIÓN de 2o grado
Introduce a: 2  Introduce b: 9  Introduce c: 1
Solución 1: -0,46   Solución 2: -17.54
ECUACIÓN de 2o grado
Introduce a: 3  Introduce b: 2  Introduce c: 1
No tiene solución. Raiz negativa 
"""

import math

print("ECUACIÓN DE 2o grado")
a = int(input("Introduce valor para a:"))
b = int(input("Introduce valor para b:"))
c = int(input("Introduce valor para c:"))

resultado_raiz = (b*b) - 4 * a * c

if resultado_raiz < 0:
    print("No tiene solución. Raiz negativa")
else: 
    resultado1 =(-b+(math.sqrt(resultado_raiz)))/(2*a)
    resultado2 =(-b-(math.sqrt(resultado_raiz)))/(2*a)
    
    print("Solución 1", "{:.2f}".format(resultado1), end=" ")
    print("Solución 2:", "{:.2f}".format(resultado2))

