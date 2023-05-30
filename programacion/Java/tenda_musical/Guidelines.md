
# EXERCICI: Crear un sistema de gestió per a una tenda de música

Classe abstracta: INSTRUMENT (atributs: String nom, Double preu, String num_serie)

La classe abstracta ha d'implementar la interfície: Afinable (que conté un mètode: afinar(), quan s'implemente el mètode en la classe abstracta farà el següent: imprimirà per pantalla "Afinat a 440 Hz")  

Classes concretes:
- FUSTA (atributs: Enum tonalitat, String material)
- METALL (atributs: int diametre, Boolean usat)

Les classes concretes han d'implementar la interfície Tocable (que conté un mètode: tocar(), quan s'implemente el mètode en les fustes, imprimirà per pantalla: "La-la-la-liii", i en els metalls: "To-to-to-taaan")

El programa ha de tindre un únic menú amb les opcions:
- Alta instrument
- Baixa instrument
- Tots els instruments
- Informació d'un instrument
- Modificar un instrument
- Ordenar per: nom, preu o número de sèrie
- Afinar un instrument
- Provar/tocar un instrument

En les funcions del menú definirem totes les interaccions amb la persona usuària (inputs).

Per a la lògica, crearem una classe específica on definirem totes les funcions que s'encarreguen de les operacions internes (buscar, donar d'alta, eliminar, reordenar...)

També crearem una classe específica per a treballar amb el llistat d'instruments de la tenda (l'hem de convertir en iterable).

Hem de crear els Comparators necessaris per a l'opció del menú d'ordenar el llistat. A part hem de definir un comparable per defecte (nom, preu o sèrie) en la classe abstracta Instrument.

## EXERCICI PART II

Preparar al menú les opcions:
- Importar dades (instruments)
- Exportar dades (instruments)
- Mostrar números de sèrie

Amb les 2 primeres opcions podrem guardar (exportar) els nostres instruments del llistat a un arxiu binari anomenat instruments.db, i també carregar (importar) els instruments des d'eixe arxiu binari al nostre programa (substituint les possibles dades existents en cas d'importació)

També es prepararà un arxiu anomenat historic.txt, on cada vegada que es done d'alta o de baixa un instrument, s'afegirà una nova línia al log, del tipus:
2023/05/21 15:08:33 - ALTA  - Nom instrument (número de sèrie)
2023/05/22 12:48:13 - BAIXA - Nom instrument (número de sèrie)
etc...

També prepararem un arxiu en format binari anomenat series.dat, on cada vegada que donem d'alta un instrument, es guardarà automàticament en format binari el seu número de sèrie. L'opció del menú de "Mostrar números de sèrie" s'encarregarà de llegir els números de sèrie de l'arxiu series.dat i mostrar-los tots per pantalla