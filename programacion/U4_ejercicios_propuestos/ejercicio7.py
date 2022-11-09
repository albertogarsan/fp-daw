""" 
Ejercicio 7 

Programa para guardar los nombres y la edad de los alumnos de un curso. Hay que pedir los datos de cada uno por pantalla. La lectura de datos terminará cuando se introduzca como nombre un guión (-)

Al terminar se mostrarán los siguientes datos: - Todos los alumnos mayores de edad. - Los dos alumnos más mayores 

"""  
    
nombres = []
edades = []

while True:	
	nombre = input("Dime el nombre de un alumno: ")
	if nombre != "-":
		nombres.append(nombre)
		edades.append(int(input("Dime su edad: ")))
	if nombre == "-": break;	

edad_max = max(edades)

print("Todos los alumnos mayores de edad: ")

for nombre, edad in zip(nombres, edades):
	if edad >= 18:
		print(nombre)

print("Los dos alumnos más mayores: ")

for nombre, edad in zip(nombres, edades):
	if edad == edad_max:
		print(nombre)


    
        
    

    
