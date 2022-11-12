""" Ejercicio 5 

Realizar un programa que inicialice una lista con 5 valores aleatorios (del 1 al 10) y posteriormente que muestre en pantalla cada elemento de la lista junto con sus unidades, decenas y miles. 

Por ejemplo si la lista es [5, 4, 2, 1, 5] 
El resultado que se mostraría por pantalla será: 

U D  C   M
5 50 500 5000
4 40 400 4000
2 20 200 2000
1 10 100 1000 
5 50 500 5000

"""
import random

lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print("U \t D \t C \t D \t")

for item in range(5, len(lista)):
    item = random.choice(lista)
    print(f"{item} \t {item*10} \t {item*100} \t {item*1000}")


