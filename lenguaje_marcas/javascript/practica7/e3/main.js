document.addEventListener("DOMContentLoaded", () => {

    const formulari = document.querySelector("#formulari")
    const classificacio = document.querySelector("#classificacio")

    formulari.addEventListener("submit", (e) => {
        e.preventDefault()
        const nota = e.target.nota.value

        if (nota < 5) {
            classificacio.textContent = "Insuficient"
        } else if (nota < 6) {
            classificacio.textContent = "Suficient"
        } else if (nota < 7) {
            classificacio.textContent = "Bé"
        } else if (nota < 9) {
            classificacio.textContent = "Notable"
        } else {
            classificacio.textContent = "Excel·lent!"
        }
    })
})