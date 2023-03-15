#Esto le dice a Python que este directorio es de hecho un paquete.

from os.path import dirname, abspath

ROOT_DIR = dirname(abspath(__file__))

###Logging initialisation code would go here###