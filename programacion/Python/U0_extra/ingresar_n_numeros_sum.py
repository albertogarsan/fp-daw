#Escribir un programa que permita al usuario el ingreso de  n numeros
#Primero debe preguntar al usuario cuantos numeros desea ingresar
#Al final del programa presente la sumatoria de dichos numeros

acum = 0 
num_ingresar = int(input("Cuántos numeros deseas ingresar? ")) #2
i = 0

#Mientras 0 sea menor a 2, entra en el bucle:
while i < num_ingresar:
    #Pide al usuario y guardalo en la variable num: 4
    num = int(input("Ingresa cada uno de los números: "))
    #Añade al acumulador el valor ingresado por el usuario: acum = 4
    acum += num 
    #Acumula 1 en la variable i(iteradora) que permitirá que en el momento que i sea menor al num_ingresar salga del bucle
    i += 1
print("Suma total: ", acum)