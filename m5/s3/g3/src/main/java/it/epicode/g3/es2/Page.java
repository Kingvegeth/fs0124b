package it.epicode.g3.es2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Page extends ComponenteLibro{
    private int numeroDiPagina;
    @Getter
    private String contenuto;

    @Override
    public int getNumeroPagine() {
        return 1;
    }

    @Override
    public void stampa() {
        System.out.println("Numero di pagina " + this.numeroDiPagina);
        System.out.println(this.contenuto);
    }

}
