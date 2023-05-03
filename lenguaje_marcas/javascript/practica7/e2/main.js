document.addEventListener("DOMContentLoaded", () => {

    const resultat = document.querySelector("#resultat")
    const formulari = document.querySelector("#formulari")
    const classificacio = document.querySelector("#classificacio")
    const p = document.querySelector("p")

    formulari.addEventListener("submit", (e) => {
        e.preventDefault()
        const altura = e.target.altura.value
        const pes = e.target.pes.value

        if (altura < 0.5 || altura > 2.5) {
            //p.style.display = "block"
            p.textContent = "L'altura ha de ser entre 0.5 i 2.5 ⚠️"
        } else if (pes < 20 || pes > 300) {
            //p.style.display = "block"
            p.textContent = "El pes ha de ser entre 20 i 300 ⚠️"
        } else {
            //p.style.display = "none"
            p.textContent = null
            console.log(p)
            const imc = parseFloat(e.target.pes.value) / Math.pow(parseFloat(e.target.altura.value), 2)

            resultat.textContent = `El resultat és ${imc.toFixed(2)}`

            if (imc < 18.5) {
                classificacio.textContent = "Pes baix"
            } else if (imc < 25) {
                classificacio.textContent = "Normal"
            } else if (imc < 30) {
                classificacio.textContent = "Sobrepes"
            } else {
                classificacio.textContent = "Obès"
            }
        }
    })

})