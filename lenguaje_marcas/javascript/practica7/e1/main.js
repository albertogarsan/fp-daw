document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari")
    const p = document.querySelector("p")

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        const p1 = e.target.p1.value;
        const p2 = e.target.p2.value;

        if (p1 === p2) {
            p.textContent = "Són exactament iguals!!!! Mare de Déu!!! 🫡"
        } else if (p1.toLowerCase() === p2.toLowerCase()) {
            p.textContent = "Són 'iguals' 🙄... Bé, sense tindre en compte les majúscules i minúcules, va!"
        } else {
            p.textContent = "Són diferents 🫣"
        }
    })
})



/*

Haz un programa que lea 2 palabras y diga si las 2 son exactamente iguales
(coincidiendo mayúsculas y minúsculas), iguales (sin tener en cuenta mayúsculas y
minúsculas) o distintas. Incluir verificación de contenido no vacío. 

*/