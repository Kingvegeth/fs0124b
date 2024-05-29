package it.epicode.g3.es2;

import java.util.List;

public class Sezione extends ComponenteLibro {
    private List<ComponenteLibro> componenti;
    private String nomeSezione;

    public Sezione(String nomeSezione, List<ComponenteLibro> componenti){
        this.nomeSezione = nomeSezione;
        this.componenti = componenti;
    }

    @Override
    public int getNumeroPagine() {
        return this.componenti.stream().mapToInt(ComponenteLibro::getNumeroPagine).sum();
    }

    @Override
    public void stampa() {
        System.out.println(this.nomeSezione.toUpperCase());
        this.componenti.forEach(ComponenteLibro::stampa);
    }
}
