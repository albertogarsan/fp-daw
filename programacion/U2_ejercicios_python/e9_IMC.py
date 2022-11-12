# alberto_garcia_propuesto9.py
# Ejercicio propuesto 9 - Programa que pida el peso y la altura del usuario para calcular el IMC - Índice de masa corporal 

def IMC(peso, altura):
    return peso / (altura * altura)

peso = float(input("¿Cuál es tu peso? "))
altura = float(input("¿Qué mides? (m) "))

IMC = IMC(peso, altura)
print ("Tu índice de masa corporal es: ", IMC)