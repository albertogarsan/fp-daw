document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari");
    const text = document.querySelector("#text");

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        if (e.target.nom.value) {
            text.textContent = "Hola " + e.target.nom.value;
        }
    })

})