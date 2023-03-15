""" Escriba un programa para iterar los primeros 10 números y en cada iteración, imprima la suma del número actual y anterior.
 """
 
prev_num = 0

for i in range(10):
    print(f"Número actual: {i} Número anterior: {prev_num} Suma: {i + prev_num}")
    prev_num = i
    
""" Número actual 0 Número anterior 0 Suma: 0
Número actual 1 Número anterior 0 Suma: 1
Número actual 2 Número anterior 1 Suma: 3
Número actual 3 Número anterior 2 Suma: 5
Número actual 4 Número anterior 3 Suma: 7
Número actual 5 Número anterior 4 Suma: 9
Número actual 6 Número anterior 5 Suma: 11
Número actual 7 Número anterior 6 Suma: 13
Número actual 8 Número anterior 7 Suma: 15
Número actual 9 Número anterior 8 Suma: 17 """
