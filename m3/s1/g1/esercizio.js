"use strict";
let costo = 0.20;
class User {
    constructor(nome, cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.credito = 0;
        this.numeroChiamate = 0;
    }
    ricarica(ammontare) {
        this.credito += ammontare;
        console.log(`Ricarica di ${ammontare}€ effettuata. il nuovo credito è ${this.credito}€.`);
    }
    chiamata(minuti) {
        let costoChiamata = minuti * costo;
        if (costoChiamata <= this.credito) {
            this.credito -= costoChiamata;
            this.numeroChiamate += minuti;
            console.log(`La chiamata è durata ${minuti} minuti`);
        }
        else {
            console.log(`Chiamata non riuscita. Credito insufficiente`);
        }
    }
    chiama404() {
        return this.credito;
    }
    getNumeroChiamata() {
        return this.numeroChiamate;
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
}
let utente = new User('Pippo', 'Franco');
utente.ricarica(10);
utente.ricarica(12);
utente.chiamata(5);
utente.chiamata(10);
utente.chiamata(400);
console.log(`Credito residuo di ${utente.nome} ${utente.cognome}: ${utente.chiama404()}€`);
console.log(`Minuti di chiamata effettuati: ${utente.getNumeroChiamata()}`);
console.log(`${utente.nome} ${utente.cognome} ha effettuato ${utente.getNumeroChiamata()} minuti di chiamata`);
utente.azzeraChiamate();
console.log(`${utente.nome} ${utente.cognome} ha effettuato ${utente.getNumeroChiamata()} minuti di chiamata`);
//# sourceMappingURL=esercizio.js.map