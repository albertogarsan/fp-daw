""" 
Ejercicio 20

Programa para registrar la información de personas. Interesa guardar el DNI, el nombre, apellidos y la edad.

La información para 4 personas podría ser:

17626679 “Pepe Soler Soler” 23 
20201232 “Sara Cortés López” 18 
17923122 “Juan Bilbao Martin” 18 
20003609 “María Orante Sanz” 19

Utiliza un diccionario llamado ‘personas’ para guardar la información utilizando el ‘dni’ como clave y los valores pueden guardarse en una tupla o una lista de los datos.

Antes de finalizar el programa, realiza un recorrido al diccionario para mostrar la información que contiene. 
"""

personas = {}

crear_otra_persona = True

while crear_otra_persona:
    
    print("Añadir persona")
    dni = input("- Escribe el DNI:")
    nombre = input("- Escribe el nombre:")
    apellidos = input("- Escribe los apellidos:")
    edad = input("- Escribe la edad:")

    personas[dni] = {"nombre": nombre, "apellidos": apellidos, "edad": edad}
    
    print(personas)

    crear_otra_persona = input("Quieres añadir otra persona?") in ["si", "Si", "SI"]


if personas:
    if len(personas) == 1:
        print("El diccionario contiene 1 persona")
    else:
        print("El diccionario contiene %d personas" % len(personas))

    for dni, datos_persona in personas:
        print(
            "%s: %s %s (%s)" % (
                dni,
                datos_persona["nombre"],
                datos_persona["apellidos"],
                datos_persona["edad"]
            )
        )
else:
    
    print("No hay personas en el diccionario")