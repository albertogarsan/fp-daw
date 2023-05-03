'use strict';

/**
 * Apartado 1
 * Realiza los siguientes pasos (muestra por consola el resultado después de aplicar cada uno):
 * - Crea un array con 4 elementos
 * - Concatena 2 elementos más al final y 2 al principio
 * - Elimina las posiciones de la 3 a la 5 (ambas incluidas)
 * - Inserta 2 elementos más entre el penúltimo y el último
 * - Muestra el array del paso anterior, pero con los elementos separados por " ==> "
 */

console.log('--------------- APARTADO 1 -----------------');
let arr = [1, 2, 3, 4]
console.log(`Este es el array con ${arr.length} elementos: ${arr}.`)
arr.push(5, 6)
arr.unshift(-1, 0)
arr.splice(3, 3)
arr.push(7, 8)
console.log(arr.join(" ==> "))

/**
 * Apartado 2
 * Crea una función que reciba como primer parámetro el nombre de un alumno, seguido
 * de un número indeterminado de notas (usa spread para agruparlas en un array).
 * Utiliza el método reduce para sumar las notas y calcula la media, que deberás mostrar por consola.
 * Posible llamada -> printMedia("Pepe", 4.25, 6, 8.5, 9)
 */

console.log('--------------- APARTADO 2 -----------------');

const notaMedia = function notaMedia(nombre, ...notas) {
    const sumaTotal = notas.reduce((acc, curr) => acc + curr)
    const resultado = +(sumaTotal / notas.length).toFixed(2)
    console.log(`La nota media de ${nombre} es de ${resultado}`)
}
console.log(notaMedia("Alberto", 4.25, 6, 8.5, 9))

/**
 * Apartado 3
 * Crea un array de cadenas y ordénalo usando el método sort de mayor a menor longitud .
 * Imprime el array original (antes de ordenarlo) y el resultado
 */

console.log('--------------- APARTADO 3 -----------------');
let cadenas = ["Eusebio", "Marc", "Sebas", "Abdo", "Alberto"]
cadenas.sort((a, b) => {
    if (a.length == b.length) {
        return a.localeCompare(b)
    } else {
        return b.length - a.length
    }
})
console.log(cadenas)


/**
 * Apartado 4
 * Crea un array de números de más de una cifra. Mapea ese array en otro que sea la suma de las cifras de cada número. No puedes usar bucles.
 * Pista: Puedes convertir los números a cadena primero y después con Array.from(cadena) la transformas a array de caracteres (que puedes sumar)
 * Imprime el array original y el resultado
 */

console.log('--------------- APARTADO 4 -----------------');
const arrayNumeros = [12, 32, 10293, 939, 1002901]
const arrayNumeros1 = arrayNumeros.map(numero => {
    const string = numero.toString()
        //return Array.from(string).reduce((acc, curr) => parseInt(acc) + parseInt(curr))
    return [...string].reduce((acc, curr) => parseInt(acc) + parseInt(curr))
})
console.log(arrayNumeros)
console.log(arrayNumeros1)

/**
 * Apartado 5
 * A partir del siguiente array que contiene productos con mensajes sobre los mismos:
 * - Filtra los mensajes que empiecen por ERROR (usa el método startsWith).
 * - Después recórrelos y mételos en un objeto Map cuya clave sea el nombre del producto
 * y cuyo valor sea un array con los mensajes de error asociados al producto.
 * - Recorre el objeto Map mostrando, para cada producto, que errores tiene asociados.
 */

console.log('--------------- APARTADO 5 -----------------');

let mensajes = [
    ['Silla', 'ERROR: Stock no coincide'],
    ['Mesa', 'Pedido de 2 unidades'],
    ['Silla', 'ERROR: El precio no puede ser menor a 1'],
    ['Mesa', 'ERROR: No se pueden enviar 0 unidades'],
    ['Cama', 'ERROR: El fabricante no tiene ese modelo'],
    ['Silla', 'Se ha borrado el producto de la base de datos'],
    ['Mesa', 'ERROR: El stock no puede ser negativo']
];

/* const mensajesError = mensajes.filter(linea => {
    return linea[1].startsWith("ERROR")
})
console.log(mensajesError) */

const mensajesError = mensajes.filter(([producto, mensaje]) => {
    return mensaje.startsWith("ERROR")
})
console.log(mensajesError)

/* const mapeoMensajes = mensajesError.reduce((acc, [producto, mensaje]) => {
    if (acc.has(producto)) {
        const arrayMensajes = acc.get(producto)
        arrayMensajes.push(mensaje)

    } else {
        acc.set(producto, [mensaje])
    }
    return acc

}, new Map())

console.log(mapeoMensajes) */

const mapeoMensajes2 = new Map();

mensajesError.forEach(([producto, mensaje]) => {
    if (mapeoMensajes2.has(producto)) {
        mapeoMensajes2.get(producto).push([mensaje])
    } else {
        mapeoMensajes2.set(producto, [mensaje])
    }
})

console.log(mapeoMensajes2)

/**
 * Apartado 6
 * Crea una función calcule el área de un triángulo. Esta función recibirá 3 parámetros:
 * 2 lados del triángulo, y el ańgulo entre ellos (en grados).
 * Para calcular el área con estos datos debemos aplicar la fórmula: (1/2)*lado1*lado2*seno(ángulo).
 * Debes tener en cuenta que para aplicar la fórmula, el ángulo debe estar en radianes. Para pasarlo
 * a radianes lo multiplicamos por PI y dividimos entre 180.
 */

console.log('--------------- APARTADO 6 -----------------');

function areaTriangulo(lado1, lado2, anguloGrados) {
    const anguloRadianes = anguloGrados * Math.PI / 180
    return (1 / 2) * lado1 * lado2 * Math.sin(anguloRadianes)
}

console.log(areaTriangulo(3, 6, 60))

/**
 * Apartado 7
 * Crea una función que reciba una cadena con una fecha en formato "YYYY-MM-DD". Muestra la fecha (ej: 2019-02-28) con
 * el siguiente formato: Jueves, 28 de Febrero de 2019.
 * Debes formatear la fecha usando los métodos de la clase Date para obtener, día de la semana, día del mes, mes, y año.
 * No puedes usar librerías como moment.js para ayudarte.
 * Para mostrar el nombre del mes o del día de la semana, puedes crearte un array que los contenga (los días de la semana empiezan por domingo -> 0)
 * Métodos de la clase Date: https://www.w3schools.com/jsref/jsref_obj_date.asp
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 7 -----------------');

function convertirFecha(fecha) {
    const resultadoFecha = new Date(fecha).toLocaleDateString("es", { weekday: "long", day: "2-digit", month: "long", year: "numeric" })

    //resultadoFecha = martes, 28 de marzo de 2023 - amb split: ["martes,", "28", "de" ...]
    const resultado = resultadoFecha.split(" ").map((texto, indice) => {
        if (indice == 0 || indice == 3) {
            const part1 = texto[0].toUpperCase();
            const part2 = texto.slice(1);
            return part1 + part2
        } else {
            return texto
        }

    }).join(" ")

    return resultado
}

console.log(convertirFecha("2023/03/28"))