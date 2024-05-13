package it.epicode.pizzeria;


import lombok.Getter;

@Getter
public abstract class Prodotto {

    protected Double prezzo;
    protected int calorie;

    public Prodotto(Double prezzo, int calorie) {
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}
