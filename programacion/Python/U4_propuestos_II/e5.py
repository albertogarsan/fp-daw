import funciones
a=int(input("Dime un día: "))
b=int(input("Dime un mes en número: "))
c=int(input("Dime un año entre el 1900 y el 2023: "))
fecha= fechaReal(a,b,c)
if fecha==True:
    print("La fecha",a,"/",b,"/",c,"es valida")
else:
    print("La fecha no es valida")