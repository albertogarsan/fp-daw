""" 
Ejercicio 4 

Programa para validar direcciones de correo electrónico mientras el usuario lo necesite.

Partiendo de una dirección de correo como ‘alumno@ieseljust.com’ podemos identificar la cuenta de usuario como alumno y el dominio es ieseljust.com.

El programa debe indicar si la dirección que le introduce el usuario es una dirección válida y separar el usuario del dominio para escribirlos como resultado.

1 # Resultado para alumno@ieseljust.com
2
3 Usuario: alumno
4
5 Servidor: ieseljust.com 

"""
def salir():
   
    respuesta = "z"
    while respuesta != "s" and respuesta != "S" and respuesta != "n" and respuesta != "N":
        respuesta = input("¿Validar otro correo? (s / n): ")
        if respuesta != "s" and respuesta != "S" and respuesta != "n" and respuesta != "N":
            print("Por favor, selecciona una de las letras correctas.")
        
    if respuesta == "n" and respuesta == "N":
        print("¡Hasta pronto!")
        


print("--------------------")
print("VALIDADOR DE CORREOE")
print("--------------------")

while True:
    correo = input("Introduce un correo electronico: ")

    if "@" in correo:
        if "." in correo:
            print("Correo electrónico válido")
            
            correo_array = correo.split("@")
            usuario = correo_array[0]
            servidor = correo_array[1] 
            
            print(f"Usuario: {usuario}")
            print(f"Servidor: {servidor}")
            
            salir()
        else:
            print("Debe añadir una extensión válida como: .com")
    else:
        print("Debe añadir @")
    
    






  





