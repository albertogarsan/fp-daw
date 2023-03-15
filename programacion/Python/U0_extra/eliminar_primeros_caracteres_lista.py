#eliminar los primeros ncaracteres de una cadena

def eliminar_caracteres(str, n):
    mostrar_a_partir_de = str[n:]
    return mostrar_a_partir_de

print("Removing characters from a string")
print(eliminar_caracteres("alberto", 2))