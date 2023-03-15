#Escribir un programa, que permita el ingreso de un numero
#Si el usuario no ingresa un numero
#Volver a pedir hasta que ingrese un numero correctamente

num = input("Ingrese un numero: ")

#Mientras lo que ingrese el usuario no sea un numero, entra en el ciclo
while not num.isdigit():
    print("Por favor ingresa correctamente")
    num = input("Ingrese un numero: ") #Hasta que lo ingrese correctamente, en ese caso, salimos del bucle
print("Gracias")


