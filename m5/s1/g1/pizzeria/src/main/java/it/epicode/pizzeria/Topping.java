package it.epicode.pizzeria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topping extends Prodotto{

    private String nome;

    public Topping(Double prezzo, int calorie, String nome) {
        super(prezzo, calorie);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", calorie=" + calorie +
                '}';
    }
}
