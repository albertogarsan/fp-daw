""" La lista dada es [10, 20, 33, 46, 55]
divisible por 5
10
20
55 """

lista = [10, 20, 33, 46, 55]

for i in range(len(lista)):
    if lista[i] % 5 == 0:
        print(lista[i])
        

for i in lista:
    if i % 5 == 0:
        print(i)
        
