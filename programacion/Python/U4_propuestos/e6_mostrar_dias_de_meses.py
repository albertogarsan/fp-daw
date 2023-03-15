""" 
Ejercicio 6 

Crear un programa que pida al usuario un número de mes (por ejemplo, el 5) y muestre cuántos días tiene (por ejemplo, 31) y el nombre del mes en cuestión (mayo).

Se deben utilizar listas y supondremos que febrero tiene 28 días. 

"""

user = int(input("Introduce un número de mes: "))

meses = ["Enero", #31 impar
         "Febrero", #28
         "Marzo", #31 impar 
         "Abril", #30 par
         "Mayo", #31 impar 
         "Junio", #30 par
         "Julio", #31 impar 
         
         "Agosto", #31 impar
         "Septiembre", #30 par
         "Octubre", #31 impar
         "Noviembre", #30 par
         "Diciembre"] #31 impar


if user == 2:
    print(f"El mes es {meses[user-1]} y tiene 28 días")
elif user < 8:
    print(f"El mes es {meses[user-1]} y tiene {(30 + (user%2))}")
else:
    print(f"El mes es {meses[user-1]} y tiene {(31 - (user%2))}")
    
    

    

""" dias = range(1, 32)
dia = list(dias)
 

if user == dia[0]:
    print(f"El mes es {meses[0]} y tiene {dia[30]} días")

if user == dia[1]:
    print(f"El mes es {meses[1]} y tiene {dia[27]} días")

if user == dia[2]:
    print(f"El mes es {meses[2]} y tiene {dia[30]} días")

if user == dia[3]:
    print(f"El mes es {meses[3]} y tiene {dia[29]} días")
    
if user == dia[4]:
    print(f"El mes es {meses[4]} y tiene {dia[30]} días")
    
if user == dia[5]:
    print(f"El mes es {meses[5]} y tiene {dia[29]} días")
    
if user == dia[6]:
    print(f"El mes es {meses[6]} y tiene {dia[30]} días")
    
if user == dia[7]:
    print(f"El mes es {meses[7]} y tiene {dia[30]} días")

if user == dia[8]:
    print(f"El mes es {meses[8]} y tiene {dia[29]} días")
    
if user == dia[9]:
    print(f"El mes es {meses[9]} y tiene {dia[30]} días")
    
if user == dia[10]:
    print(f"El mes es {meses[10]} y tiene {dia[29]} días")

if user == dia[11]:
    print(f"El mes es {meses[11]} y tiene {dia[30]} días")
    
if user >= 13:
    print("Debe ser un número entre 1 y 12")

 """