"""EJ - 1 Realiza un programa que vaya pidiendo y leyendo números no nulos hasta que se introduzca
un 0. Mostrará si se ha leído algún número negativo, total de números positivos leídos y total de
números negativos leídos."""

"""
PROGRAMA NÚMEROS
Leyendo número(0 para finalizar): 4 -5 -9 2 21 18 54 0
Números analizados ...
Sí que hay algún número negativo
Total de números positivos = 5
Total de números negativos = 2
"""

print("PROGRAMA DE NÚMEROS")

i = 1 #para entrar en el bucle
num_positivo = 0
num_negativo = 0

while i != 0:
    num_user = int(input("Leyendo número (0 para finalizar) :"))
    i = num_user  #asignamos a i el valor de numero introducido por el usuario (num_user) para llegado el momento, cuando introduzca 0 salir del bucle
    
    if num_user < 0:
        num_negativo += 1 
    elif num_user > 0:
        num_positivo += 1
    else:
        print("Números analizados ...")
        if num_negativo >= 1:
            print("Sí hay algun número negativo")
        
        print("Total de números positivos ingresados :", num_positivo)
        print("Total de números negativos ingresados :", num_negativo)
        
    




        

        
         
    


    



    