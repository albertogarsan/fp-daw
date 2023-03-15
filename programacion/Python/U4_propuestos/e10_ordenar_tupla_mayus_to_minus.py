""" 
Ejercicio 10 

Programa que dada una tupla con caracteres mayúsculas/minúsculas alternativos, modifique la asignación de la tupla de manera que sea una tupla con todos los caracteres en mayúscula en primera posición y todos los caracteres en minúscula en las posiciones finales. 

Por ejemplo si la tupla es t = ('C', 'h', 'R', 'm', 'A', 's', 'M', 'o',
       'T', 'y', 'c')

el resultado será:

("C", "R", "A", "M", "T", "c", "h", "m", "s", "o", "i")

"""

from curses.ascii import islower


t = ('C', 'h', 'R', 'm', 'A', 's', 'M', 'o', 'T', 'y', 'c')

#Comprueba true or false / true > false/ 1 > 0
def minusculas(l):
    return l.islower()

sort = sorted(t, key = minusculas)
print(sort)

