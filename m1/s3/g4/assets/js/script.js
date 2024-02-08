//Variabili globali
let board = document.querySelector(".board");
let button = document.querySelector(".button");

let numeroCelle = 76;

//creazione delle celle
for (let i = 1; i < numeroCelle + 1; i++) {
  let cella = document.createElement("div");
  cella.classList.add("cell");
  cella.innerText = i;
  board.appendChild(cella);
}

//estrazione del numero con la pressione di 'button'
let numeriEstratti = [];
button.addEventListener("click", () => {
  let cell = document.querySelectorAll(".cell");

  if (numeriEstratti.length == numeroCelle) return;
  let numero;

  do {
    numero = Math.ceil(Math.random() * numeroCelle);
  } while (numeriEstratti.includes(numero));
  numeriEstratti.push(numero);

  for (let i = 0; i < cell.length; i++) {
    if (cell[i].innerText == numero) {
      cell[i].classList.add("selected");
    }
  }
});
