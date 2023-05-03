/*Haz una web que pida un entero y diga si es par o impar, utilizando una función que reciba un parámetro y devuelva el resultado.*/

document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari");
    const resultat = document.querySelector("span")

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        if (e.target.enter.value % 2 == 0) {
            resultat.textContent = "Es par!"
            resultat.style.color = "green"
        } else if (e.target.enter.value % 2 == 1) {
            resultat.textContent = "Es impar!"
            resultat.style.color = "red"
        }
    })

})