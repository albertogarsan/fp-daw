//Parrafo
const parrafo = document.createElement("p")
document.body.appendChild(parrafo)
parrafo.innerHTML = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius natus, ullam aspernatur quas dolores a vitae mollitia iusto ex quaerat officia nulla molestias possimus et provident quibusdam deserunt, voluptate adipisci."

//Boton toggle
const button = document.createElement("button")
document.body.appendChild(button)
const buttonText = document.createTextNode("Ocultar párrafo")
button.appendChild(buttonText)
button.addEventListener('click', () => {
    parrafo.classList.toggle("hidden")
    if (parrafo.classList.contains("hidden")) {
        buttonText.textContent = "Mostrar párrafo"
    } else {
        buttonText.textContent = "Ocultar párrafo"
    }
})