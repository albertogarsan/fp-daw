""" EJ - 1 

Hacer un programa para realizar diferentes operaciones matemáticas:

- Primero mostrará (por pantalla) un mensaje: “Iniciando el programa...”

- Se pedirá que el usuario introduzca su nombre (que se utilizará en la despedida) 

- A continuación, se indicarà que se necesitan 3 valores

- Se pedirà, por teclado, un valor entero
También se pediràn, por teclado, dos numeros reales

- A continuación se harán los cálculos:
    · La suma de todos los valores
    · El producto de todos
    · La división del resultado del producto entre el de la suma
    · La división entera del producto entre la suma
    · El resto de la división entera

- Mostrar los resultados obtenidos por pantalla, indicando cuál es el resultado para cada operación 

- Finalizar el programa con el mensaje: “Hasta la próxima, nombre_del_usuario” """

import time 

print("Iniciando el programa...")
time.sleep(1)

nombre = str(input("Introduzca su nombre: "))

valor_entero = int(input("Genial, ahora necesitaremos 3 valores, el primero debe de ser un valor entero: "))
valor_real_1 = float(input("¡Qué bueno! Ahora un número real: "))
valor_real_2 = float(input("Y por último, de verdad 🫣 introduce otro número real más: "))

print("A continuación se harán los cálculos... ")
time.sleep(2)

resultado_suma = valor_entero + valor_real_1 + valor_real_2
resultado_producto = valor_entero * valor_real_1 * valor_real_2

print("Para la suma de todos los valores: ", resultado_suma)
print("Para el producto de todos: ", resultado_producto)
print("Para la división del resultado del producto entre el de la suma: ", resultado_producto / resultado_suma)
print("Para la división entera del producto entre la suma: ", resultado_producto // resultado_suma)
print("Para el resto de la división entera: ", resultado_producto % resultado_suma)

time.sleep(2)
print("Muchas gracias por colaborar,",nombre)
