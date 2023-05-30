
const button = document.createElement("button")
document.body.appendChild(button)
const buttonText = document.createTextNode("Dark mode")
button.appendChild(buttonText)

button.addEventListener("click", () => {
    document.body.classList.toggle("dark")
    if (document.body.classList.contains("dark")){
        buttonText.textContent = "White mode"
    } else {
        buttonText.textContent = "Dark mode" 
    }
})
