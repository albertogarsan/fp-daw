document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari");
    const text = document.querySelector("#text");

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        if (e.target.edad.value) {
            text.textContent = "Tu edad es " + e.target.edad.value;
        }
    })

})