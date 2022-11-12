""" 
EJ - 1 

Programa que pida un valor N para calcular el sumatorio, productorio y valor intermedio con las funciones sumatorioN, productorioN i intermedioN Estas funciones, a partir de ese valor N (que será el parámetro de cada función) retornará:

1 - Su sumatorio: la suma de tots los números desde 1 a N

2 - Su productorio: el producto de todos los números desde 1 a N, y 3 - El valor intermedio que hay entre 1 y N.
   
Nota: El valor intermedio, de una lista de números ordenados, es el número que está en la posición del medio si el número de elementos es impar o la suma de los dos valores del medio si el número de elementos es par.

Ejemplos:

En la lista= 2, 5, 6, 10, 12 el número intermedio es 6
En la lista= 5, 6, 10, 12 el número intermedio es 8 (6+10 dividido entre 2) 

"""

import funciones

numero = int(input("Introduce un valor: "))

funciones.sumatorioN(numero)
funciones.productorioN(numero)
funciones.intermedioN(numero)