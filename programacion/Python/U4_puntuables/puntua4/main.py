""" 
El programa principal es para el procesamiento de frases de acuerdo a este enunciado.

El usuario podrá procesar tantas frases como quiera, de manera consecutiva (primero una, luego otra…), hasta que decida parar la ejecución 

En el programa principal, main.py, se mostrará el siguiente menú para procesar cada frase :

1. Analizar frase
2. Buscar palabra
3. Ocultar frase
4. Resumen
5. Salir
-

En cada opción se trata de:
1. Analizar frase : lista de palabras que componen la frase, lista de longitudes de las palabras, lista de cantidad de vocales y lista de cantidad de consonantes.

2. Buscar palabra : realiza un método propio que indique si està o no la palabra indicada en la frase. En el caso que sí esté deberá mostrar el número de veces que aparece.

3. Ocultar frase : obtener y mostrar los códigos ascii de las letras que componen la frase (el espacio en blanco se traducirá por 0)

4. Resúmen : obtener y mostrar la suma de los códigos ascii de las letras que componen la frase.

5. Salir : opción para indicar que se quiere parar la ejecución del programa

"""

""" def analizar_frase():
    print("Has elegido analizar frase")

def buscar_palabra():
    print("Has elegido analizar palabra")
    
def ocultar_frase():
    print("Has elegido ocultar frase")
    
def resumen():
    print("Has elegido resumen")
    
def salir():
    print("Has elegido salir")

menu = {
        "1": ("Analizar frase", analizar_frase),
        "2": ("Buscar palabra", buscar_palabra),
        "3": ("Ocultar frase", ocultar_frase),
        "4": ("Resumen", resumen),
        "5": ("Salir", salir)
} 

for item in menu:
    print(f"{item} - {menu[item][0]}")
    
item = input("Selecciona una item del menu: ")
menu[item][1]() #Senyalem al diccionari menu, a la posició que rebem de l'usuari i cridarà a la posició de la funció (segon element de la tupla: [1]) per a executar l'acció després de rebre la info sol·licitada a l'usuari.
    
 """
 
from libreria import*

i=1

while i==1:
    n=input("Dime una frase:")
    print("1. Analizar frase")
    print("2. Buscar palabras")
    print("3. Ocultar frase")
    print("4. Resumen")
    print("5. Salir")
    a=int(input("_:"))
    if a==1:
        Analiz(n)
    if a==2:
        Buscador(n)
    if a==3:
        Ocultar(n)
    if a==4:
        Resumen(n)
    if a==5:
        Salir()
        i=2