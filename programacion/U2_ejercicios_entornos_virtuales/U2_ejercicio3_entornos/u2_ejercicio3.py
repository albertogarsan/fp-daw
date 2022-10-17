from flask import Flask
import webbrowser

def main():
    ruta = "prueba.html"

with open(ruta, mode="w", encoding="utf-8") as fichero: 
    print("<!DOCTYPE html>", file=fichero)
    print('<html lang="es">', file=fichero) 
    print("<head>", file=fichero)
    print(' <meta charset="utf-8">', file=fichero)
    print(" <title>HTML 5</title>", file=fichero)
    print('<meta name="viewport" content="width=device-width, initial-scale=1.0">', file=fichero)
    print("</head>", file=fichero)
    print("", file=fichero)
    print("<body>", file=fichero)
    body="<div style='border:3px solid green;width:400px;padding:30px'><h3 style='color:red'>PRUEBA HTML5</h3><p>Ejemplo de páginaHTML - versión 5</p></div>"
    print(body, file=fichero)
    print("</body>", file=fichero)
    print("</html>", file=fichero)
    
webbrowser.open(ruta)

if __name__ == "__main__": 
    main()
    