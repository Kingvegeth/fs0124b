/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

let area = (a,b=0) =>  a*b
console.log(area(3,6));

/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

function crazySum(a,b=0) {
    if (a==b) return (a+b)*3
    return a+b
}
console.log(crazySum(2,5));

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

function crazyDiff(a) {
    if (a>19) return Math.abs(19-a)
    return 19-a
}
console.log(crazyDiff(7));

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

function boundary(a) {
    if (a>=20&&a<=100||a==400) return true
    return false
}
console.log(boundary(36));

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

function epify(a) {
    const parola = 'EPICODE '
    if (a.startsWith(parola)) return a
    return parola.concat(a)
}
console.log(epify('Ti paga la terapia'));

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

function check3and7(a) {
    if (a>0&&(a%3===0||a%7===0)) return true
    return false
}
console.log(check3and7(12));

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

let reverseString = (a) => a.split("").reverse().join("");
console.log(reverseString('Istituto psichiatrico'));


/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

function upperFirst(a) {
    let p = a.split(" ")
    for (let i = 0; i < p.length; i++) {
        p[i]=p[i].charAt(0).toUpperCase()+p[i].slice(1) //provato a mettere la for su una riga sola ma risultava poco leggibile
    }
    return p.join(" ")
    }
console.log(upperFirst('ciao, sto facendo un esercizio di javascript'));

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

let cutString = (a) => a.slice(1,-1)
console.log(cutString('Stringa di prova'));

/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

function giveMeRandom(n) {
    let arrandom = []
    for (let i = 0; i < n; i++) arrandom.push(Math.floor(Math.random()*11))
    return arrandom
}
console.log(giveMeRandom(3))