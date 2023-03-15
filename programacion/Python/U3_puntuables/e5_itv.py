"""
EJ - 5 opcional. Realiza un programa que calcule el importe a pagar por un vehículo al pasar la ITV. El vehículo puede ser un ciclomotor, motocicleta, coche, camión o tractor. El importe se calculará según los datos disponibles en el siguiente enlace:

Definim els mètodes principals. Hem escollit aquesta forma de fer-ho perquè un break en la funció salir() carregaria directament la funció continuar() seguint el sentit normal del programa

"""

def menu_principal():
    for opcion in opciones:                                 
        #el bucle for mostrarà el menú principal. La iteració recorre l'index 0 de tot el diccionari "opciones" que en aquest cas és text. 
        if opcion%2==0:
            #mostrar el menú en dos columnes separades per una condició de números parells
            print(f"{opcion} - {opciones[opcion][0]}", end="\n")
        else:
            print(f"{opcion} - {opciones[opcion][0]}", end="\t")
    seleccionar_opcion()
    
def seleccionar_opcion():
    opcion=-1
    while opcion<=0 or opcion>len(opciones):
        #preparem un bucle per a que l'input de l'usuari siga correcte.
        opcion=int(input("Selecciona una opción: "))
        #demanem a l'usuari que seleccione un element dels mostrats en el menú principal
        if opcion<=0 or opcion>len(opciones): #Si es menor o igual a 0 o major a la longitud de les opcions = malament.
            print("El valor introducido es incorrecto. Vuelva a intentarlo.")
        else:
            opciones[opcion][1]()
            #cridem les funcions de l'opció triada per l'usuari que es troba a l'index 1 dels elements del diccionari "opciones"

def submenu(tipos):
    #després de provar varies opcions optem per generalitzar el submenú que accedirà als "tipos" de cada mètode del diccionari opciones
    for tipo in tipos:
        print(f"{tipo} - {tipos[tipo][0]}")
    seleccionar_tipos(tipos) #Despres de mostrar el submenu cridem a la funció encarregada de comprobar quin altre element del menu agafa

def seleccionar_tipos(tipos):
    tipo=-1
    while tipo<=0 or tipo>len(tipos):
        tipo=int(input("Selecciona un tipo: "))
        if tipo<=0 or tipo>len(tipos):
            print("Elige un valor de la tabla.")
        else:
            region="z"
            while region!="s" and region!="n":
                region=input("¿El vehículo procede de fuera de la Comunidad Valenciana? (s/n): ").lower()
                if region!="s" and region!="n":
                    print("Introduce una respuesta correcta.")
                elif region=="s":
                    print(f"El precio de la revisión del vehículo es de {tipos[tipo][1]-sonido}€")        
                elif region=="n":
                    print(f"El precio de la revisión del vehículo es de {tipos[tipo][1]}€")

#Definim els mètodes que seran cridats per l'opció del menú seguint la formulació amb els diccionaris           
def accion1():
    tipos = {
        1:("Sin emisiones", 26.09 ),
        2:("Con emisiones", 33.07 ),
        3:("Cuadriciclo diésel", 47.75)
        }
    submenu(tipos)

def accion2():
    accion1()

def accion3():
    tipos = {
        1:("Turismo gasolina no catalizado", 45.74),
        2:("Turismo gasolina catalizado", 52.73),
        3:("Turismo diésel", 67.40),
        4:("Turismo diésel (ant. 1980)", 45.74),
        5:("Vehículo hasta 3500kg diésel", 67.40),
        6:("Vehículo hasta 3500kg gasolina cat.", 52.72)
    }
    submenu(tipos)

def accion4():
    tipos =  {
        1:("Vehículo pesado", 86.90),
        2:("Remolque pesado", 55.14)
    }
    submenu(tipos)

def accion5():
    tipos = {
        1:("Tractor/Maq. agrícola", 13.12),
        2:("Remolque agrícola", 13.12)
    }
    submenu(tipos)

def salir():
    while True:
        salir=input("¿Seguro que desea salir? (s/n): ")
        if salir.lower()!="s" and salir.lower()!="n":
            print("¿(S)í o (N)o?")
        elif salir.lower()=="n":
            menu_principal()
            break
        elif salir.lower()=="s":
            print("Programa finalizado")
            exit()

def continuar():
    while True:
        continuar=input("¿Quieres consultar otro tipo de vehículo? (s/n): ") 
        if continuar.lower()!="s" and continuar.lower()!="n": 
            print("Escoge un respuesta correcta.", end=" ")
        elif continuar.lower()=="n": 
            print("Programa finalizado.")
            exit()
        elif continuar.lower()=="s":
            break
#Creem el diccionari que mostrarà la iteració for del mètode menu_principal() i conté la resta de mètodes 

opciones = {
    1:("Ciclomotor", accion1),
    2:("Motocicleta", accion2),
    3:("Coche", accion3),
    4:("Camión", accion4),
    5:("Tractor",accion5),
    6:("Salir",salir)
    }
#Creem la variable sonido per poder calcular els preus dels vehicles que no són de la CV
sonido=11.25
#Presentem el programa
print("ITV - GANDIA - Selecciona tipo de vehículo.")
#Bucle principal
while True: 
    menu_principal()
    continuar()