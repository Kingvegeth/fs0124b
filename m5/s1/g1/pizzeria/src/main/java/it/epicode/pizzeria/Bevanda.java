package it.epicode.pizzeria;

public class Bevanda extends Prodotto{
    private final String nome;

    public Bevanda(String nome, Double prezzo, int calorie){
        super(prezzo, calorie);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bevanda{" +
                ", nome='" + nome + '\'' +
                "calorie=" + calorie +
                ", prezzo=" + prezzo +
                '}';
    }
}
