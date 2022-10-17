""" 
EJ - 5 El servicio de endocrinología del Hospital de Gandia necesita un programa que calcule el peso recomendado de una persona. Escribe un programa que lea el peso actual, la altura en metros y la edad de una persona y muestre su peso recomendado según la fórmula:

peso = (altura_en_cm – 100 + 10 %edad) * 0.9
También debe indicar si está en el peso recomendado o si necesita perder o aumentar peso (según esté por arriba o por abajo del peso recomendado). 
"""
""" EJEMPLO:
ENDOCRINO - PESO RECOMENDADO - PERSONAS ADULTAS
Introduce el peso(Kg): 50
Introduce la altura(m): 1.75
Introduce la edad: 23
El peso recomendado para tu edad es: 69.57
Estás por debajo del peso recomendado.
Necesitas AUMENTAR tu PESO """

print(("ENDOCRINO - PESO RECOMENDADO - PERSONA ADULTAS"))

peso = float(input("Introudce el peso (Kg): "))
altura = float(input("Introuce la altura (m): ")) * 100
edad = float(input("Introduce la edad: "))
peso_recomendado = ((altura - 100) + (10 % edad)) * 0.9

print(f"El peso recomendado para tu edad es: {peso_recomendado}")

if peso > peso_recomendado:
    print("Estás por encima del peso necomendado.")
    print("Necesitas REDUCIR tu PESO")
elif peso < peso_recomendado:
    print("Estás por debajo del peso necomendado.")
    print("Necesitas AUMENTAR tu PESO")
else:
    print("Estás en el peso necomendado.")

