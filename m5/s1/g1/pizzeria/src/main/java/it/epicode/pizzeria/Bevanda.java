package it.epicode.pizzeria;

public class Bevanda extends Prodotto{
    private String nome;

    public Bevanda(String nome, Double prezzo, int calorie){
        super(prezzo, calorie);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bevanda{" +
                "calorie=" + calorie +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
