"""
Se acercan las votaciones para elegir a la persona más querida de un grupo. Contamos con la lista que contiene nombres de personas más queridas, con la letra inicial en mayúscula

Escribe un programa que permita a todos los estudiantes votar por la persona más querida ingresando solo el nombre del estudiante a votar, considerar que solo hay una fila para acercarse a vorat (Los estudiantes votan uno a uno), las votaciones finalizan cuando escriban "fin" en lugar de un nombre.

Al finalizar las votaciones el programa deberá mostrar lo siguiente:
- El total de estudiantes que votaron
- El ganador
- Votos del ganador
"""
#lista en paralelo: se trata de pasarle el indice de la lista personas a candidatos
personas = ["Angie", "Andrés", "Gabriela", "Oscar", "Kevin", "Victor", "Gustavo", "Annie", "Maria"]
votos = [0]*len(personas) #Nou 0's

print(40*"-")
print("elecciones".center(40, " ").upper())
print(40*"-")
print(f"Esta es la lista de candidatos a la persona más querida: \n")
for persona in personas:
    print(f"{persona}",end=", ")
print("\n")

candidato = input("Ingresa el nombre del candidato o ingrese 'FIN': ") #Oscar

while candidato != "FIN":
    if candidato in personas:
        #Oscar en persona es igual al index 3
        posicion = personas.index(candidato)#para conocer la posicion/indice del array personas concuerde con lo que introduzca el usuario
        
        #              3      contador +1 vot a la posició 3.
        votos[posicion]+=1
    else: 
        print("Voto no válido")
    candidato = input("Ingresa el nombre del candidato o ingrese 'FIN': ")
    
votantes = sum(votos)
votos_ganador = max(votos)
posicion_ganador = votos.index(votos_ganador)
ganador = personas[posicion_ganador] 

print("El total de estudiantes que votaron fue: {}".format(votantes))
print("Gana {} con {} votos".format(ganador, votos_ganador))

