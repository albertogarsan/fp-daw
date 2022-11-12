"""
EJ - 1 Un granjero quiere calcular el área máxima de un terreno rectangular de lados 𝑥 y 100 − 2𝑥, para los valores de x entre 10 y 30. Realizar un programa que muestre las posibles combinaciones y cuál es la de mayor área que puede construir. Es decir, la salida del programa sería así:

La salida del programa para x entre 10 y 30 sería así:

Lado1(x)     Lado2(100-2x)       Area
10               80               800
11               78               858
...
25               50              1250
...
30               40              1200
El área máxima es 1250 para los lados 25 y 50

"""
print("Área máxima")

area_maxima = 0

print("Lado1(x)\t Lado2(100-2x)\t Area")

for i in range(10, 31):
    lado1 = i
    lado2 = 100 - (2*i)
    area = lado1 * lado2
    print(lado1, "\t", "\t", lado2, "\t", "\t", area)
    
    if area > area_maxima:
        area_maxima = area
        lado1_maximo = lado1
        lado2_maximo = lado2
                                     
print("El area máxima es", area_maxima, "para los lados", lado1_maximo, lado2_maximo)

