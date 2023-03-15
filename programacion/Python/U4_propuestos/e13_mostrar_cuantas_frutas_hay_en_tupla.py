""" 
Ejercicio 13

Dada la cadena s=“manzana|pera|manzana|cereza|pera|manzana|pera|pera|cereza|pera|fresa”

Crea un programa que inserte los elementos que están separados por “|” en una lista. 

Sabiendo que la lista creada sólo tiene cuatro elementos diferentes (es decir, “manzana”, “pera”, “cereza” y “fresa”), 

creará otra lista donde cada elemento sea una tupla con el nombre de la fruta y su multiplicidad (es decir, el número de veces que aparece en la lista original).

Imprimirá el contenido de cada tupla en una línea independiente (es decir, en la primera línea: la “manzana” está presente 3 veces)

El resultado será:

cuenta = [("manzana", 3), ("pera", 5), ...]

[("manzana",3), ("pera",5), ("cereza",2), ("fresa",1)] 

la manzana está presente 3 veces
la pera está presente 5 veces
la cereza está presente 2 veces
la fresa está presente 1 vez

"""

s = "manzana|pera|manzana|cereza|pera|manzana|pera|pera|cereza|pera|fresa"

lista = s.split("|")
print(lista)

fruta = lista[0] 
 
lista1 = []

for fruta in lista:
    if fruta not in lista1:
        lista1.append(fruta)

for fruta in lista1:
    print("La",fruta ,"está presente", lista.count(fruta), "veces")




