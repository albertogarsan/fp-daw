document.addEventListener("DOMContentLoaded", function() {
    const formulari = document.querySelector("#formulari");
    const resultat1 = document.querySelector("#resultat1");
    const resultat2 = document.querySelector("#resultat2");

    formulari.addEventListener("submit", (e) => {
        e.preventDefault();
        const preu = parseFloat(e.target.preu.value);
        const descompte = parseFloat(e.target.descompte.value);
        const iva = parseInt(e.target.selectorIva.value);
        const preuDescomptat = preuAmbDescompte(preu, descompte);
        const preuFinal = preuAmbIva(preuDescomptat, iva);
        resultat2.innerHTML = "El preu final és de: " + preuFinal.toFixed(2);
    })

    function preuAmbDescompte(preu, descompte) {
        const preuDescomptat = preu * (1 - descompte / 100);
        resultat1.innerHTML = "El preu amb descompte és de: " + preuDescomptat.toFixed(2);
        return preuDescomptat;
    }

    function preuAmbIva(preu, iva) {
        const preuAmbIva = preu * (1 + iva / 100);
        return preuAmbIva;
    }
})