//Parrafo
const parrafo = document.createElement("p")
document.body.appendChild(parrafo)
const parrafoText = document.createTextNode("Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius natus, ullam aspernatur quas dolores a vitae mollitia iusto ex quaerat officia nulla molestias possimus et provident quibusdam deserunt, voluptate adipisci.")
parrafo.appendChild(parrafoText)

//Botones
const button1 = document.createElement("button")
document.body.appendChild(button1)
const button1Text = document.createTextNode("Cambiar a azul")
button1.appendChild(button1Text)
button1.addEventListener('click', () => {
    parrafo.style.color = "blue"
})

const button2 = document.createElement("button")
document.body.appendChild(button2)
const button2Text = document.createTextNode("Cambiar a rojo")
button2.appendChild(button2Text)
button2.addEventListener('click', () => {
    parrafo.style.color = "red"
})

const button3 = document.createElement("button")
document.body.appendChild(button3)
const button3Text = document.createTextNode("Cambiar a verde")
button3.appendChild(button3Text)
button3.addEventListener('click', () => {
    parrafo.style.color = "green"
})