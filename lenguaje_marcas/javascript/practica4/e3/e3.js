//Parrafo
const parrafo = document.createElement("p")
document.body.appendChild(parrafo)
/* parrafo.innerHTML = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius natus, ullam aspernatur quas dolores a vitae mollitia iusto ex quaerat officia nulla molestias possimus et provident quibusdam deserunt, voluptate adipisci." */
const parrafoText = document.createTextNode("Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius natus, ullam aspernatur quas dolores a vitae mollitia iusto ex quaerat officia nulla molestias possimus et provident quibusdam deserunt, voluptate adipisci");
parrafo.appendChild(parrafoText);

//Botones
const button2 = document.createElement("button")
document.body.appendChild(button2)
const button2Text = document.createTextNode("Ocultar párrafo")
button2.appendChild(button2Text)
button2.addEventListener('click', () => {
    parrafo.style.display = "none"
})

const button1 = document.createElement("button")
document.body.appendChild(button1)
const button1Text = document.createTextNode("Mostrar párrafo")
button1.appendChild(button1Text)
button1.addEventListener('click', () => {
    parrafo.style.display = "block"
})

