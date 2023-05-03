document.addEventListener("DOMContentLoaded", function() {
    const formulariSumar = document.querySelector("#formulariSuma");
    const formulariRestar = document.querySelector("#formulariRestar");
    const formulariMultiplicar = document.querySelector("#formulariMultiplicar");
    const formulariDivision = document.querySelector("#formulariDivision");
    const formulariResto = document.querySelector("#formulariResto");

    formulariSumar.addEventListener("submit", (e) => {
        e.preventDefault();

        const resultado = e.target.querySelector("p")
        const a = parseFloat(e.target.a.value)
        const b = parseFloat(e.target.b.value)

        if (a && b) {
            resultado.textContent = `El resultado de la suma es ${a + b}`
        }

    })

    formulariRestar.addEventListener("submit", (e) => {
        e.preventDefault();

        const resultado = e.target.querySelector("p")
        const a = parseFloat(e.target.a.value)
        const b = parseFloat(e.target.b.value)

        if (a && b) {
            resultado.textContent = `El resultado de la resta es ${a - b}`
        }

    })

    formulariMultiplicar.addEventListener("submit", (e) => {
        e.preventDefault();

        const resultado = e.target.querySelector("p")
        const a = parseFloat(e.target.a.value)
        const b = parseFloat(e.target.b.value)

        if (a && b) {
            resultado.textContent = `El resultado de la multiplicación es ${a * b}`
        }

    })

    formulariDivision.addEventListener("submit", (e) => {
        e.preventDefault();

        const resultado = e.target.querySelector("p")
        const a = parseFloat(e.target.a.value)
        const b = parseFloat(e.target.b.value)

        if (a && b) {
            resultado.textContent = `El resultado de la división es ${a / b}`
        }

    })

    formulariResto.addEventListener("submit", (e) => {
        e.preventDefault();

        const resultado = e.target.querySelector("p")
        const a = parseFloat(e.target.a.value)
        const b = parseFloat(e.target.b.value)

        if (a && b) {
            resultado.textContent = `El resultado del módulo es ${a % b}`
        }

    })


})