"use strict";

const newEventForm = document.querySelector("#newEvent");
const imgPreview = document.querySelector("#imgPreview");
const inputName = document.querySelector("#name");
const inputDate = document.querySelector("#date");
const inputDescripcion = document.querySelector("#description");
const inputPrice = document.querySelector("#price");
const inputImg = document.querySelector("#image");
const eventsContainer = document.querySelector("#eventsContainer")

newEventForm.image.addEventListener('change', event => {
    let file = event.target.files[0];

    let reader = new FileReader();

    if (file) reader.readAsDataURL(file);
    reader.addEventListener('load', e => {
        // Aquí quitamos la clase d-none a la imagen “imgPreview”
        document.getElementById("imgPreview").src = reader.result;
    });

    imgPreview.classList.remove("d-none");
});

newEventForm.addEventListener("submit", function(e) {
    e.preventDefault();

    const itemsFormulari = [inputName, inputDate, inputDescripcion, inputPrice, inputImg]

    for (let item of itemsFormulari) {
        item.classList.remove("is-invalid");

        if (item.value === '') {
            item.classList.add("is-invalid");
        } else {
            item.classList.add("is-valid");
        }
    }

    let fallaAlguno;
    for (let item of itemsFormulari) {
        if (item.value === '') {
            fallaAlguno = true;
        }
    }

    if (!fallaAlguno) {
        //Añadir nuevo evento
        const card = document.createElement("div");
        card.classList.add("card");
        const cardImgTop = document.createElement("img");
        card.appendChild(cardImgTop);
        cardImgTop.setAttribute("src", imgPreview.src);
        cardImgTop.classList.add("card-img-top");
        const cardBody = document.createElement("div");
        cardBody.classList.add("card-body")
        card.appendChild(cardBody);
        const cardTitle = document.createElement("h4");
        cardTitle.classList.add("card-title");
        const cardTitleText = document.createTextNode(inputName.value);
        cardTitle.appendChild(cardTitleText);
        const cardText = document.createElement("p")
        cardText.classList.add("card-text")
        const cardTextText = document.createTextNode(inputDescripcion.value)
        cardText.appendChild(cardTextText)
        cardBody.appendChild(cardTitle)
        cardBody.appendChild(cardText)
        const cardFooter = document.createElement("div")
        cardFooter.classList.add("card-footer")
        const textMuted = document.createElement("small")
        textMuted.classList.add("text-muted")
        cardFooter.appendChild(textMuted)
        const textMutedText = document.createTextNode(inputDate.value.split("/").reverse().join("-"))
        textMuted.appendChild(textMutedText)
        const floatRight = document.createElement("span")
        floatRight.classList.add("float-right")
        const floatRightText = document.createTextNode(`${inputPrice.value} €`)
        floatRight.appendChild(floatRightText)
        textMuted.appendChild(floatRight)
        card.appendChild(cardFooter)

        //Debes añadir este elemento creado a <div id="eventsContainer">
        eventsContainer.appendChild(card)

        //Resto de acciones
        newEventForm.reset();
        const inputs = newEventForm.querySelectorAll("input");

        inputs.forEach(function(input) {
            input.classList.remove("is-valid", "is-invalid")
        });

        imgPreview.classList.add("d-none");
        imgPreview.src = "";
    }


});