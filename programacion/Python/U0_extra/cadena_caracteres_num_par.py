""" Imprimir caracteres de una cadena que están presentes en un número de índice par """

""" Por ejemplo, str = "pynative"debería mostrar 'p', 'n', 't', 'v'. """

str = "alberto"

for i in range(len(str)):
    #str = i % 2
    #print(str[i])
    if (i % 2 == 0):
        print(str[i])
