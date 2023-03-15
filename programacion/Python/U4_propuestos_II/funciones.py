# Nombre del archivo funciones.py
# Declarar todas las funciones propias que se quieren agrupar para reutilizar


""" 
EJ - 1 

Programa que pida un valor N para calcular el sumatorio, productorio y valor intermedio con las funciones sumatorioN, productorioN i intermedioN Estas funciones, a partir de ese valor N (que será el parámetro de cada función) retornará:

1 - Su sumatorio: la suma de tots los números desde 1 a N

2 - Su productorio: el producto de todos los números desde 1 a N, y 3 - El valor intermedio que hay entre 1 y N.
   
Nota: El valor intermedio, de una lista de números ordenados, es el número que está en la posición del medio si el número de elementos es impar o la suma de los dos valores del medio si el número de elementos es par.

Ejemplos:

En la lista= 2, 5, 6, 10, 12 el número intermedio es 6
En la lista= 5, 6, 10, 12 el número intermedio es 8 (6+10 dividido entre 2) 

"""

def sumatorioN(n):
    sumatorio = 0
    lista = list(range(1, n+1))
    #print(lista)
    for item in lista:
        sumatorio = sumatorio + item
    print(f"La suma de tots els números des de 1 a {n} és: {sumatorio}")
   

def productorioN(n):
    #print("ProductorioN")
    productorio = 1
    lista = list(range(1, n+1))
    #print(lista)
    for item in lista:
        productorio = productorio * item
    print(f"El producte de tots els números des de 1 a {n} és: {productorio}") 
    
def intermedioN(n):
    #print("IntermedioN") 
    """ lista = list(range(1, n+1))
    intermedio = lista[-1] / 2
    print(f"El intermedi de tots els números des de 1 a {n} és: {intermedio}")  """
    lista=[]
    for i in range(1, n+1):
        lista.append(i)
    print(lista)
    mit = int(n/2)
    if n % 2 == 0:
        num=lista[mit]
        num1=lista[mit-1]
        return (num1, num)

    else:
        return lista[mit]
    

def esTriangulo(a, b, c):
    if (a > (b + c)) or (b > (a + c)) or (c > (a + b)):
        resultado = False
    else:
        resultado = True   
             
    return resultado

def tipoTriangulo(a, b, c):
    if (a == b) and (a == c):
        print("Triangulo equilatero")
    elif (a != b) and (a != c) and (b != c):
        print("Triangulo escaleno")
    else:
        print("Triangulo isosceles")


#mirar el patro de que equilater son tots els costats iguals, i lescaleno tots diferents


""" ((a == b) and (a != c)) or ((a == c) and (a != b)) or ((b==c) and (b !=a)) """


def numeroPrimo(num):
    for n in range(2, num):
        if num % n == 0:
            print("No es primo", n, "es divisor")
            return False
    print("Es primo")
    return True

def fechaReal(a,b,c):
    fecha=True
    if a > 31:
        fecha=False
    if b > 12:
        fecha=False
    if c < 1900 or c > 2023:
        fecha=False
    return fecha