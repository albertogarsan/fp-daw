document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari");
    const text = document.querySelector("#text");
    const nom = document.querySelector("#nom")

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        if (nom.value) {
            text.textContent = "Hola " + nom.value;
        }
    })

})