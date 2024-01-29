/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/

/* 
In Javascript, i datatype sono le diverse tipologie di dati che possono essere assegnati ad una variabile.
una variabile è uno spazio della memoria del tuo PC che può contenere diversi tipi di informazioni. Prova ad immaginare il cassetto di un mobile: uno spazio che puoi riempire come meglio credi!
in queste variabili puoi inserire le più disparate tipologie di dati, e ti adesso te ne descriverò alcuni:

Numero:
Il numero è un tipo di dato che comprende, appunto, i numeri!
Prova a pensare ad i numeri che hai imparato a scuola, come ad esempio 1, 2, 3, 4, ecc ecc.
Se per esempio voglio spiegare a Javascript che la variabile chiamata "nomeVariabile" contiene il numero 1, posso scrivergli:
let nomeVariabile = 1

Stringa:
La stringa è un datatype che comprende caratteri, come ad esempio le parole o le lettere dell'alfabeto.
Se per esempio voglio spiegare a Javascript che la variabile chiamata "nomeVariabile" contiene la parola 'cane', posso scrivergli:
let nomeVariabile = 'cane'

Booleano:
Booleano indica un tipo di dato che può avere solo due valori: vero o falso.
Visto che Javascript utilizza la lingua inglese, da ora in poi useremo le parole true(vero) e false(falso).
prova a pensare ad una monetina: se la lanci questa atterrerà su una delle due facce. Il risultato quindi potrà essere soltanto Testa o Croce!
Questo tipo di dato si utilizza in tutti quei casi in cui possono esserci solo due esiti ad un problema: per esempio tutte le domande a cui le uniche risposte sono "sì" o "no"
Se per esempio voglio spiegare a Javascript che la variabile chiamata "nomeVariabile" è di tipo booleano, posso scrivergli:
let nomeVariabile = true , oppure let nomeVariabile = false

Esistono molti altri datatype in Javascript, ma quelli che ti ho spiegato sono i più semplici e quelli che solitamente vengono insegnati il primo giorno.
*/

/* ESERCIZIO 2
 Crea una variable chiamata "myName" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

const myName = 'Simone';

/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/

let risultato_somma = 15 + 20;

/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

let x = 12;

/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "myName" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

/*
  myName = 'Luigi';
  l'assegnazione del valore 'Luigi' alla variabile myName non è possibile in quanto myName è di tipo Const (è una costante).
  provando ad eseguire questa istruzione si ottiene il seguente errore: "Uncaught TypeError: Assignment to constant variable."
*/

/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/

let risultato_sottrazione = x - 4;

/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

let name1 = 'john';
let name2 = 'John';
console.log( name1 == name2 );

//EXTRA

console.log( name1.toLowerCase() == name2.toLowerCase() );