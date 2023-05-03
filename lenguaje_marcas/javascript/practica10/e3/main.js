const formulari = document.querySelector("form")
const btnMostra = document.querySelector("#button")
const smartphones = []
const items = document.querySelector("ul")
const section = document.querySelector("section")




formulari.addEventListener("submit", (e) => {
    e.preventDefault()

    let marca = e.target.marca.value
    let model = e.target.model.value
    let preu = e.target.preu.value

    if (!marca && !model && !preu) {
        alert("Indica almenys una marca, model o preu")
    } else {
        let smartphone = { marca, model, preu, }
        smartphones.push(smartphone)
    }
})

btnMostra.addEventListener("click", () => {
    removeChilds()
        /* items.innerHTML = null */
    for (smartphone of smartphones) {
        let item = document.createElement("li")
        let itemText = document.createTextNode(`Marca: ${smartphone.marca}, Model: ${smartphone.model}, Preu: ${smartphone.preu}`)
        item.appendChild(itemText)
        items.appendChild(item)
        section.style.display = "block"
    }

})

function removeChilds() {
    while (items.firstChild) {
        items.removeChild(items.firstChild)
    }
}