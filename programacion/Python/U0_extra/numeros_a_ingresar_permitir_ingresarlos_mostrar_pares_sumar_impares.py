#Escribir un programa que pregunte cuantos numeros se van a introducir, 
# Permitir el ingreso de dichos numeros 
# Y mostrar por pantalla cuantos numeros son pares 
# Y la suma de todos los imares.


num_total = int(input("¿Cuántos números quieres introducir? ")) 
par = 0 
impar = 0

#mientras que 0 sea menor que 4 entra en el bucle
i = 0
while i < num_total:
    num = int(input("Ingresa un número: ")) #2 3 1 4
    
    if num % 2 == 0:
        par += 1
    else: 
        impar += num
    i += 1


print(f"La cantidad de números pares ingresados es: {par}")
print(f"La suma de todos los impares ingresados es: {impar}")

"""
cont= 0
acum=0
num_total = int(input("¿Cuántos números quieres introducir? ")) 
for i in range(num_total):
    print("--Ciclo " + str(1+1)+"--")
    num = int(input("Ingrese un numero: "))
    if num%2==0:
      cont+=1  
    else:
        acum+=num

print(f"La cantidad de números pares ingresados es: {cont}")
print(f"La suma de todos los impares ingresados es: {acum}")
     """

        
    