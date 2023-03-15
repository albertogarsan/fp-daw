numbers_x = [10, 20, 30, 40, 10]
numbers_y = [75, 65, 35, 75, 30]

""" Lista dada: [10, 20, 30, 40, 10]
el resultado es verdadero

números_y = [75, 65, 35, 75, 30]
el resultado es falso """

def mismo_numero(lista):
    if lista[0] == lista[-1]:
        print("El resultado es verdadero")
    else:
        print("El resultado es falso")
        
resultado = mismo_numero(numbers_x)
resultado = mismo_numero(numbers_y)