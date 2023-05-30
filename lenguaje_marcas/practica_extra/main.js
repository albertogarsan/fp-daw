/**
 * Apartado 1
* Crea una función que reciba 2 cadenas por parámetro. Dicha función imprimirá por consola qué cadena
* tiene mayor longitud. Si el tipo de algún parámetro no es string (typeof param !== "string"),
* debes imprimir un error.
* Llama a la función 3 veces con diferentes parámetros. En una de esas llamadas pásale por parámetro un valor que no sea string.
*/

function mifuncion(a, b){
    if (typeof a !== "string" || typeof b !== "string") {
        console.log("Error, no es un string")
    } else {

        if (a.length > b.length){
            console.log("La cadena de major longitud és: " + a)
        } else if (a.length == b.length) {
            console.log("Són de la mateixa longitud")
        } else {
            console.log("La cadena de major longitud és: " + b)
        }
    }
}

mifuncion("hola", "alberto")


/**
 * Apartado 2
 * Crea una función que reciba 2 números por parámetro, el primer número indicará cuantas veces debemos imprimir el segundo
 * por pantalla, pero en cada iteración muéstra el valor anterior multiplicado por 2.
 * Ejemplo: Si recibimos 4 y 6 imprimiremos: 6 12 24 48
 * Llama a la función varias veces.
 */

/* function dosNums(a, b){
    if (a <= 0) {
        console.log("Error, el primer número tiene que ser mayor a cero");
        return;
    }

    for (let i = 0; i < a; i++){
        console.log(b * (i + 1))
    }
}

dosNums(2, -6) */

/**
 * Apartado 3
 * Crea una función que reciba 2 parámetros. El primero será una cadena y el segundo otra cadena que contendrá un caracter.
 * Convierte ambos parámetros a cadena y comprueba que efectivamente, el segundo parámetro tiene una longitud de 1.
 * Debes mostrar cuantas veces aparece el caracter recibido en la cadena.
 * Ejemple: Si recibimos "carcasa" y "a", debemos indicar que aparece 3 veces dicha letra en la cadena.
 * Llama a la función varias veces.
 */

/* function mifuncion(paraula, caracter){
    stringA = paraula.toString()
    stringB = caracter.toString()

    if (stringB.length !== 1) {
        console.log("La cadena no tiene 1 caracter")
        return;
    }

    let c = 0
    /* for (let i = 0; i < a.length; i++){
        if (b == a[i]){
            c++
        }
    } 
    for (let lletra of paraula) {
        if (caracter == lletra){
            c++
        }
    }

    console.log(caracter + " aparece " + c + " veces en la cadena " + paraula)

}

mifuncion("holaaaaa", "a") */

/**
 * Apartado 1
 * Realiza los siguientes pasos (muestra por consola el resultado después de aplicar cada uno):
 * - Crea un array con 4 elementos
 * - Concatena 2 elementos más al final y 2 al principio
 * - Elimina las posiciones de la 3 a la 5 (ambas incluidas)
 * - Inserta 2 elementos más entre el penúltimo y el último
 * - Muestra el array del paso anterior, pero con los elementos separados por " ==> "
 */

/* const miArray = [1,2,3,4]
miArray.push(5,6)
miArray.unshift(-1, 0)
miArray.splice(2, 3)
miArray
miArray.splice(-1, 0, 7, 8)
miArray */

/**
 * Apartado 2
 * Crea una función que reciba como primer parámetro el nombre de un alumno, seguido
 * de un número indeterminado de notas (usa spread para agruparlas en un array).
 * Utiliza el método reduce para sumar las notas y calcula la media, que deberás mostrar por consola.
 * Posible llamada -> printMedia("Pepe", 4.25, 6, 8.5, 9)
 */

/* const arrayObjectes = [{nota: 4.24},{nota: 6},{nota: 8.5},{nota: 9}]

const notaMedia = function notaMedia(nombre, ...notas) {
    const sumaTotal = notas.reduce((acc, curr) => acc + curr.nota)
    const resultado = +(sumaTotal / notas.length).toFixed(2)
    console.log(`La nota media de ${nombre} es de ${resultado}`)
}
console.log(notaMedia("Alberto", ...arrayObjectes))
 */
/**
 * Apartado 3
 * Crea un array de cadenas y ordénalo usando el método sort de mayor a menor longitud .
 * Imprime el array original (antes de ordenarlo) y el resultado
 */

/* let arraySort = ["hola que tal", "alberto", "marc quewwwwwwwwww tal"]
let arraySort2 = [10000, 3, 299] */

/* arraySort.sort((a, b) => {
    return b.length - a.length
}) */

/* arraySort2.sort((a, b) => {
    return b - a
}) */

//alfabèticament
/* arraySort.sort((a, b) => {
    return b.localeCompare(a)
})

arraySort
arraySort2
arraySort


let arrayObjectes2 = [{nom: "alberto", edat: 93}, {nom: "marc", edat: 202}, {nom: "adria", edat: 143}] */

/* arrayObjectes2.sort((a, b) => {
    return a.edat - b.edat
}) */

/* arrayObjectes2.sort((a, b) => {
    return a.nom.localeCompare(b.nom)
})

arrayObjectes2 */

/**
 * Et passe una cadena dstrings i has de mapejarlo i has de dir quantes vegades apareix la llletra o en eixos strings
 */

let cadenaStrings = ["holooo", "formigo", "melo"]

let cadenaString2 = cadenaStrings.map((cadena) => {
    return [...cadena].reduce((accTotal, lletra)=> {
        if (lletra === "o"){
            accTotal += 1
        }
        return accTotal
    }, 0)
})

cadenaString2