const smartphones = [{
        id: 1,
        marca: "Apple",
        model: "Iphone 14",
        variant: "PRO",
        preu: "1000€",
        color: "Verd"
    },
    {
        id: 2,
        marca: "Apple",
        model: "Iphone 14",
        variant: "Plus",
        preu: "990€",
        color: "Black diamond"
    },
    {
        id: 3,
        marca: "Apple",
        model: "Iphone 14",
        variant: "Default",
        preu: "850€",
        color: "White"
    },
]

for (smartphone of smartphones) {
    console.log(`id: ${smartphone.id}, marca: ${smartphone.marca}, variant: ${smartphone.variant}, precio: ${smartphone.preu}, color: ${smartphone.color}`)

    //console.log(smartphone["id"]) Output expected: 1
    //console.log(smartphone.id) Output expected: 1
}

//console.log(smartphones[0]["id"]) Output expected: 1
//console.log(smartphones[0].id) Output expected: 1