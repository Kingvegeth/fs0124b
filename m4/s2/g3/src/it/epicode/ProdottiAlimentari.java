package it.epicode;

public class ProdottiAlimentari extends Product implements ItsEdible{

    private String dataDiScadenza;


    @Override
    public void mangia() {
        System.out.println("MMM buono!");
    }

    @Override
    public void mettiInFrigo() {
        System.out.println("Messo in frigo");
    }
}
