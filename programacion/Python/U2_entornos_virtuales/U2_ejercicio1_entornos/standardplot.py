import matplotlib.pyplot as plt

# coordenadas x
left=[1,2,3,4,5]

# altura
height = [25, 14, 17, 30, 5]

# etiquetas
tick_label = ['una', 'dos', 'tres', 'final', 'extra']

# plotting
plt.bar(left, height, tick_label = tick_label,
        width = 0.8, color = ['purple', 'blue'])

# nombre eje x
plt.xlabel('x - parámetros')

# nombre eje y
plt.ylabel('y - valores')

# título
plt.title('Resultado!')

# Mostrar el gráfico
plt.show()
