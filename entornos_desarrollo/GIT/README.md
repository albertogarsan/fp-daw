| Command | Description |
| :--- | :--- |
| `git` | Obtenemos un listado de ayuda básico |
| `git help init`| Obtenemos información sobre el comando init |
| `git init --help` | Otra manera de obtener información sobre el comando init |
| `git --version`| Ver la versión de git
| `git config --global user.name "Alberto"`| Configurar tu nombre de usuario |
| `git config --global user.email "correo@correoe.com"`| Configurar tu correoe |
| `git config --global core.editor "code --wait"`| Establece vsc as editor y wait para que la terminal se quede esperando hasta que cerremos nuestro editor |
| `git config --global color.ui auto` | Usa colores en la salida y de esta forma mostrar una información mucho más significativa y usable |
| `git config --global core.autocrlf input` | Dependiendo del SO, en MacOs es input para que autogestiones. wn windows debería ser TRUE. |
| `git config --global -e` | Para ver el archivo de configuración global |
| `git config --list` | Lista los parámetros configurados |
| `git clone`| Trae a nuestro repo local, el trabajo remoto |
| `git init`| Inicializar git
| `git status` | Lista todas las *novedades o modificiaciones* del fichero |
| `git log` | Muestra los commits realizados |
| `git log --oneline`| Muestra los commits realizados en versión corta |
| `git log --oneline -1`| Muestra el último commit realizado en versión corta |
| `git log --oneline -4`| Muestra los últimos 4 commits realizados en versión corta |
| `git log --oneline --graph --all --decorate`| Muestra los commits realizados en versión corta en representación gráfica |
| `git checkout -- archivo.txt` | Descarta los cambios en el directorio de trabajo |
| `git reset HEAD archivo.txt` | Descarta los cambios en la zona de stage | 
| `git add archivo.txt` | Pasa el archivo.txt a la zona de stage |
| `git add .` | Pasa todos los archivos a la zona de stage |
| `git commit -m "Añado el archivo.txt"` | Captura una instantánea de los cambios preparados en ese momento del proyecto tras haber pasado archivo.txt a la zona de stage con `git add` | 
| `git commit -am "Descripción"` | Se utiliza para aplicar git add y git commit, pero este comando solo funciona si primero hiciste al menos una vez git add sobre los archivos que estas trabajando |
| `git commit --amend -m "Cambio el mensaje del último commit"` | Cambiar el mensaje del último commit |
| `git annotate`| Muestra quién ha hecho cambios sobre el archivo.txt |
| `git revert 8c21c7e` | Revierte el estado a un commit, generando un nuevo commit que deshace los cambios en el commit indicado, aplicando los cambios a la rama actua. |
| `git checkout 8c21c7e -- archivo.txt` | Revierte un archivo de un commit |
| `git diff` | Muestra las diferencias de los ficheros que **no han estado** en la zona de stage |
| `git branch` | Para ver las ramas que tenemos creadas |
| `git branch rama1` | Creación de la rama rama1 |
| `git branch -av` | Muestra las ramas del repositorio |
| `git checkout rama1`| Cambiar de la rama master a la rama1 |
| `git checkout -b rama1` | Es una forma de crear y cambiar directamente de la rama master a la rama1 |
| `git branch -m rama1 nombre_nuevo` | Renombrar rama1 a nombre_nuevo |
| `git branch -d nombre_nuevo` | Borrar una rama |
| `git merge` | Fusión de ramas. Primero tendremos que ubicarnos en la rama a la que queremos llevar los cambios (normalmente las master) y le pasaremos el `git merge rama1` de tal manera que mergearemos rama1 en la mster |
| `git merge --abort` | Para abortar la fusión entre ramas | 