//pulsante per aggiungere una task alla lista
const addButton = document.getElementById('add-button');
addButton.addEventListener('click', function (e) {
  e.preventDefault();
  let taskDaInserire = document.getElementById("textbox").value;
  let creaLi = document.createElement("li");
  creaLi.textContent = taskDaInserire;
  document.querySelector('.lista').appendChild(creaLi);
  document.getElementById("textbox").value = ""
});

//task completata
let lista = document.querySelectorAll('ul li');
