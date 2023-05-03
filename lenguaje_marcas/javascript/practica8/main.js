//Haz una web que pida un número entero positivo e imprima todos los números enteros desde el 0 hasta el número introducido.

function problema1() {
    let enter = prompt("Introdueix un número enter positiu: ")

    while (enter <= 0) {
        enter = prompt("Introdueix un número enter vàlid: ")
    }

    let i = 0;
    while (i <= enter) {
        let p = document.createElement("p");
        let pText = document.createTextNode(`El número: ${i++}`);
        document.body.appendChild(p)
        p.appendChild(pText)
        console.log(`El número: ${i}`)
    }
}

//problema1();
//problema2();
problema3();

// Haz una web que pida un número entero positivo e imprima todos los números enteros desde el 0 hasta el número introducido.

function problema2() {
    let enter = prompt("Introdueix un número enter positiu: ")

    while (enter <= 0) {
        enter = prompt("Introdueix un número enter vàlid: ")
    }

    for (let i = 0; i <= enter; i++) {
        let p = document.createElement("p");
        let pText = document.createTextNode(`El número: ${i}`);
        document.body.appendChild(p)
        p.appendChild(pText)
    }
}


//Hacer una web que pida 2 números enteros y escriba todos los números entre estos números introducidos. Hazla de dos formas possibles:
// Utiliza la estructura while para la escritura de mayor a menor valor numérico.
//Utiliza la estructura for para la escritura de menor a mayor valor numérico.


function problema3() {
    let input1 = prompt("Introdueix un número enter positiu (1/2): ")
    while (input1 <= 0) {
        input1 = prompt("Introdueix un número enter vàlid: ")
    }
    let input2 = prompt("Introdueix un número enter positiu (2/2): ")
    while (input2 <= 0) {
        input2 = prompt("Introdueix un número enter vàlid: ")
    }

    let menor;
    let major;

    if (input1 > input2) {
        menor = input2;
        major = input1;
    } else {
        menor = input1;
        major = input2;
    }

    for (let j = menor; j <= major; j++) {
        let p = document.createElement("p");
        let pText = document.createTextNode(`El número: ${j}`);
        document.body.appendChild(p)
        p.appendChild(pText)
    }

    let i = major;
    while (i >= menor) {
        let p = document.createElement("p");
        let pText = document.createTextNode(`El número: ${i--}`);
        document.body.appendChild(p)
        p.appendChild(pText)
    }


}