#Ejercicio propuesto 6
# alberto_garcia_propuesto6.py

# Haz un programa que pregunte cuántos años tiene alguien y que muestre por pantalla la cantidad de años que faltan para la mayoría de edad (18 zños) y para jubilarse (67 años). 

edad = int(input("¿Cuántos años tienes?"))
mayoria_edad= 18
edad_jubilarse = 67

if edad < mayoria_edad:
    print("Te faltan ", (mayoria_edad - edad), "para la mayoría de edad")
elif edad < edad_jubilarse:
    print("Te faltan ", (edad_jubilarse - edad), "para jubilarte.")
