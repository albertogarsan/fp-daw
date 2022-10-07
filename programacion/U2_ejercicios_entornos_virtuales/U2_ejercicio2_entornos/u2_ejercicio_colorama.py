from colorama import Fore, Back, Style

print(Fore.BLUE+50*"=")
print(Fore.MAGENTA+"APLICANDO COLORAMA")
print(Fore.BLUE+50*"=")

print(Back.LIGHTBLACK_EX + "Un pequeño fondo")

print(Back.RESET+50*"=")
print(Fore.BLUE+"Aplicando color al texto")
print(50*"=")

print(Fore.GREEN + "Una frase cualquiera de color")
print(Fore.RED + "Segunda frase coloreada")
print("Aplica el color que quieras en cualquiera de los textos")

print(Fore.YELLOW +50*"=")
print("Finalizando...")
print(50*"=")

print(Style.RESET_ALL,end="") 
print(".....FIN")