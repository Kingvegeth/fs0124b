package it.epicode.pizzeria;

import java.util.List;

public class Pizza extends Prodotto{
    private String nome;

    private List<Topping> listaTopping;


    public Pizza(String nome, List<Topping> listaTopping) {
        super(4.0, 1000);
        this.nome = nome;
        this.listaTopping = listaTopping;
        this.calorie = setCalorie(listaTopping);
        this.prezzo = setPrezzo(listaTopping);
    }

    public int setCalorie(List<Topping> listaTopping){
        int tot = 1000;
        if(listaTopping != null){
            for (int i=0; i<listaTopping.size();i++){
                tot += listaTopping.get(i).getCalorie();
            }
        }
        return tot;
    }

    public Double setPrezzo(List<Topping> listaTopping){
        double tot = 4.0;
        if (listaTopping != null){
            for (int i=0; i<listaTopping.size();i++){
                tot += listaTopping.get(i).getPrezzo();
            }
        }
        return tot;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", calorie=" + calorie +
                ", listaTopping=" + listaTopping +
                '}';
    }
}
