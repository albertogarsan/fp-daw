def Analiz(n):
    vocal=0
    conso=0
    delim=" "
    lista=n.split(delim)
    print("La frase contiene",len(lista),"palabras")
    for i in range(len(lista)):
        print("la palabra",lista[i],"contiene",len(lista[i]),"caracteres")
        a=list(lista[i])
        for letra in a:
            if letra.lower() in "aeiou":
                vocal+=1
            else:
                conso+=1
    print("la cantidad de vocales es:",vocal)
    print("la catidad de consonantes es:",conso)

def Buscador(n):
    b=input("Dime la palabra que buscas: ")
    print("La pabra aparece ",n.count(b),"veces")

def Ocultar(n):
    for i in range(len(n)):
        a=ord(n[i])
        if n[i]==" ":
            a=0
        print(n[i],"=",a)

def Resumen(n):
    a=list(n)
    lista=[]
    for i in range(len(a)):
        b = ord(a[i])
        lista.append(b)
    for i in lista:
        sum += i
    print("Suma de los códigos ascii de las letras: ", sum)

def Salir():
    import sys
    sys.exit()