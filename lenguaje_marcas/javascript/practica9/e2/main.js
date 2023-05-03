/* Fes una pàgina que demane quantes paraules vols inserir en un array i, després, et demane introduïr-les una a una. Els elements s'enmagatzenaran en un array que inicialment estarà buit, s'hauràn d'ordenar i mostrar-les ordenades. */
const numParaules = prompt("Introdueix la quantitat de paraules: ");
const qParaules = parseInt(numParaules);
console.log(qParaules)
const array = [];


for (let i = 1; i <= numParaules; i++) {
    let paraules = prompt("Introdueix una paraula")
    array.push(paraules)
    array.sort()
}

let p = document.createElement("p");
let pText = document.createTextNode(`Paraules introduïdes a l'array: ${array.join(", ")}`);
document.body.appendChild(p)
p.appendChild(pText)