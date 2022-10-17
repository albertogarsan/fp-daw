""" EJ - 4 Programa que pida las notas de las 3 evaluaciones del módulo de Programación y calcule la nota final (teniendo en cuenta que la primera y segunda evaluación ponderan lo mismo y la última evaluación pondera 0.5) .También mostrará si la calificación obtenida corresponde a suspendido, suficiente, bien, notable o sobresaliente. """

""" NOTAS DEL MÓDULO PRG - DAW
Nota 1a evaluación: 7.5
Nota 2a evaluación: 4
Nota 3a evaluación: 8.3
Nota Final:  7.03 - NOTABLE """

print("NOTAS DEL MÓDULO PRG - DAW")

nota_1evaluacion = float(input("Nota 1a evaluación: ")) 
nota_2evaluacion = float(input("Nota 2a evaluación: "))
nota_3evaluacion = float(input("Nota 3a evaluación: "))

nota_final = (nota_1evaluacion*0.25 + nota_2evaluacion*0.25 + nota_3evaluacion*0.5) 


if nota_final < 5:
    print("Nota Final: %6.2f - SUSPENDIDO" %(nota_final))
elif nota_final >= 5 and nota_final < 6:
    print(f"Nota Final: %6.2f - SUFICIENTE" %(nota_final))
elif nota_final >= 6 and nota_final <= 8:
    print(f"Nota Final: %6.2f - BIEN" %(nota_final))
elif nota_final >= 8 and nota_final <= 9:
    print(f"Nota Final: %6.2f - NOTABLE" %(nota_final))
elif nota_final <= 10:
    print(f"Nota Final: %6.2f - SOBRESALIENTE" %(nota_final))
else:
    print(f"Nota Final: %6.2f - M.H"%(nota_final))
    
