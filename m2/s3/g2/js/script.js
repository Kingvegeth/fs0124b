//ESERCIZIO 1

const btnSet = document.getElementById('btn-set');
const btnRemove = document.getElementById('btn-remove');

let lastName = document.getElementById('last-name');
let storageStatus = document.getElementById('storage-state');

const storageState = () =>{
    if (localStorage.getItem('name')!=null) storageStatus.innerText = 'Pieno'
else storageStatus.innerText = 'Vuoto'
}

storageState();

btnSet.addEventListener('click', function(e){
    e.preventDefault();
    let name = document.getElementById('nome').value;
    localStorage.setItem('name',name);
    lastName.innerText = localStorage.getItem('name')
    document.getElementById('nome').value='';
    storageState();
})

btnRemove.addEventListener('click', function(e){
    e.preventDefault();
    localStorage.clear();
    storageState();
})


//ESERCIZIO 2

let counter = parseInt(sessionStorage.getItem('counter')) || 0;
let btnReset = document.getElementById('reset')

const updateCounter = () =>{
    counter++;
    sessionStorage.setItem('counter', counter);
    document.getElementById('counter').innerText = counter;
}

setInterval(updateCounter, 1000);

document.getElementById('counter').innerText = counter;

btnReset.addEventListener('click', function() {
    counter = 0;
    document.getElementById('counter').innerText = 0;
})