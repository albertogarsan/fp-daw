/**
 * 
 * Autor: Alberto Garcia
 */

'use strict';

/**
 * Apartado 1
 * Crea una función que reciba 2 cadenas por parámetro. Dicha función imprimirá por consola qué cadena
 * tiene mayor longitud. Si el tipo de algún parámetro no es string (typeof param !== "string"),
 * debes imprimir un error.
 * Llama a la función 3 veces con diferentes parámetros. En una de esas llamadas pásale por parámetro un valor que no sea string.
 */

console.log('--------------- APARTADO 1 -----------------');

function cadenas(a, b) {

    //Comprobar error
    if (typeof a !== "string" || typeof b !== "string") {
        console.log("Error: debe ser cadenas");
    }

    // Comprobar longitud
    if (a.length > b.length) {
        console.log("La primera cadena es más larga");
    } else if (b.length > a.length) {
        console.log("La segunda cadena es más larga");
    } else {
        console.log("Ambas cadenas tienen la misma longitud");
    }

}

// Outputs
cadenas("Hola", "Mundo"); // La cadena 2 es más larga
cadenas("JavaScript", "es genial"); // La cadena 1 es más larga
cadenas("hola", 123); // Error: ambos parámetros deben ser cadenas


/**
 * Apartado 2
 * Crea una función que reciba 2 números por parámetro, el primer número indicará cuantas veces debemos imprimir el segundo
 * por pantalla, pero en cada iteración muéstra el valor anterior multiplicado por 2.
 * Ejemplo: Si recibimos 4 y 6 imprimiremos: 6 12 24 48
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 2 -----------------');

function imprimirNveces(veces, aImprimir) {
    // Capturar el numero
    let numActual = aImprimir;
    for (let i = 0; i < veces; i++) {
        //Mostrar cada numero
        console.log(numActual);
        // Multiplicar-lo en cada iteració
        numActual = numActual * 2;
    }
}

//Output
imprimirNveces(4, 6); // 6 12 24 48
imprimirNveces(3, 1); // 1 2 4
imprimirNveces(5, -3); // -3 -6 -12 -24 -48


/**
 * Apartado 3
 * Crea una función que reciba 2 parámetros. El primero será una cadena y el segundo otra cadena que contendrá un caracter.
 * Convierte ambos parámetros a cadena y comprueba que efectivamente, el segundo parámetro tiene una longitud de 1.
 * Debes mostrar cuantas veces aparece el caracter recibido en la cadena.
 * Ejemple: Si recibimos "carcasa" y "a", debemos indicar que aparece 3 veces dicha letra en la cadena.
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 3 -----------------');

function cadenaCaracter(caracteres, letra) {

    let numVeces = 0;

    for (let i = 0; i < caracteres.length; i++) {
        if (caracteres[i] == letra) {
            numVeces += 1;
        }
    }

    console.log("En la palabra " + caracteres + " la letra " + letra + " apararece " + numVeces + " veces en la cadena");
}

cadenaCaracter("camaleon", "a");
cadenaCaracter("camaleon", "f");
cadenaCaracter("cocoloco", "o");

/**
 * Apartado 4
 * Crea una función que reciba 3 parámetros (nombre de producto, precio e impuesto en porcentaje sobre 100).
 * Dicha función hará lo siguiente:
 * - Los parámetros deberán tener un valor por defecto por si no los recibe que deben ser: "Producto genérico", 100 y 21.
 * - Convierte el nombre de producto a string (por si acaso) y los otros 2 a número. Si el precio o el impuesto no son
 *   numéros válidos (NaN) muestra un error. Si son válidos, muestra por consola el nombre del producto y el precio final contando impuestos.
 * - Llama a la función varias veces, omitiendo parámetros, con todos los parámetros, y pasándo algún valor no númerico en el precio o impuesto.
 */

console.log('--------------- APARTADO 4 -----------------');

function producto(nombre = "Producto genérico", precio = 100, impuesto = 21) {

    let nom = nombre.toString();

    if (isNaN(precio) || isNaN(impuesto)) {
        console.log("ERROR FATAL!");
    } else {
        console.log("El producto es " + nom + " y su precio es de " + precio + " €, con un impuesto de " + impuesto);
        //console.log(typeof(nom));
    }

}

producto("Ambientador", 20, 21);
producto("Ambientador", "20v", 21);
producto(39393, 20, 21);

/**
 * Apartado 5
 * Crea una función de tipo flecha (arrow function) que reciba 2 parámetros. Una cadena completa y un trozo de cadena a buscar.
 * La función debe comprobar si el trozo de cadena de búsqueda se encuentra dentro de la cadena completa e imprimir
 * por consola un mensaje indicando si ha encontrado coincidencia o no.
 * La búsqueda no debe ser sensible a mayúsculas o minúsculas, por lo que debes comparar ambas cadenas previa transformación
 * a minúsculas (o a mayúsculas). Ej: La cadena "Santiago de Compostela" contiene la cadena de búsqueda "COMPO".
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 5 -----------------');

let comprovarCadena = (cadena, lletres) => {

    console.log(`La letra "${lletres}" ${cadena.toLowerCase().includes(lletres.toLowerCase()) ? 'es' : 'no es'} en la cadena`);
    // Expected output: "La letra "hola" es en la cadena" || "La letra "javascript" no es en la cadena"
}

comprovarCadena("Hola món", "hola");

/* function comprovarCadena(cadena, lletres) {

    console.log(`La letra "${lletres}" ${cadena.toLowerCase().includes(lletres.toLowerCase()) ? 'está' : 'no está'} en la cadena`);
    // Expected output: "La letra "hola" es en la cadena" || "La letra "javascript" no es en la cadena"
}

comprovarCadena("Hola món", "hola"); */