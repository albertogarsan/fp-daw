#Enter Python code here and hit the Run button.
#Dados dos números enteros, devuelve su producto solo si 
#el producto es igual o menor que 1000, de lo contrario, 
#devuelve su suma.

def multiplicacion_or_suma(num1, num2):
    product = num1 * num2
    if product <= 1000:
        return product
    else:
        return num1 + num2
    
result = multiplicacion_or_suma(20,30) #600 product
print(result)

result = multiplicacion_or_suma(2000,30) #2030 sum
print(result)