/*
Haz una web que pida 3 enteros y devuelva el valor del número mayor introducido, utilizando una función con 3 parámetro de entrada.
*/

function encontrarMayor(num1, num2, num3) {
    return Math.max(num1, num2, num3);
}

function mostrarMayor() {
    const n1 = parseInt(document.getElementById("n1").value);
    const n2 = parseInt(document.getElementById("n2").value);
    const n3 = parseInt(document.getElementById("n3").value);

    const mayor = encontrarMayor(n1, n2, n3);
    document.getElementById("resultat").innerHTML = "El <b> número mayor </b> introducido es " + mayor;
}