document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari")
    const span1 = document.querySelector("#resultat1")
    const span2 = document.querySelector("#resultat2")
    const span3 = document.querySelector("#resultat3")
    const span4 = document.querySelector("#resultat4")
    const span5 = document.querySelector("#resultat5")
    const div = document.querySelector("div")

    div.style.display = "none"

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        const radi = parseFloat(e.target.radi.value);
        const altura = parseFloat(e.target.altura.value);
        div.style.display = "block"
        span1.textContent = perimetroBase(radi)
        span2.textContent = areaBase(radi)
        span3.textContent = areaLateral(altura, radi)
        span4.textContent = areaTotalCilindro(altura, radi)
        span5.textContent = volumenCilindro(radi, altura)
    })
})

function perimetroBase(radi) {
    return +(2 * Math.PI * radi).toFixed(2);
}

function areaBase(radi) {
    return +(Math.PI * Math.pow(radi, 2)).toFixed(2);
}

function areaLateral(altura, radi) {
    const base = perimetroBase(radi);
    return +(base * altura).toFixed(2);
}

function areaTotalCilindro(altura, radi) {
    return +(areaLateral(altura, radi) + (areaBase(radi) * 2)).toFixed(2);
}

function volumenCilindro(radi, altura) {
    return +(areaBase(radi) * altura).toFixed(2);
}