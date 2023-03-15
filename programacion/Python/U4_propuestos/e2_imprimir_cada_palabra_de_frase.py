""" Programa que dada una frase imprima cada palabra en una línea y nos diga el número de palabras de la frase. """

cadena = str(input("Escribe una frase: "))
#Creamos un array de una cadena introducida por el usuario
palabras = cadena.split() 

#Recorremos el array y printeamos el contenido
for i in range(0, len(palabras)):
    print(palabras[i])

#Longitud del array creado para saber el numero de palabras de la frase.
print(len(palabras))

