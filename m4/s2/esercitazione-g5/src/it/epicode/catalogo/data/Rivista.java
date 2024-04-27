package it.epicode.catalogo.data;

public class Rivista extends Pubblicazione {


    private Frequenza frequenza;

    public Rivista(Long ISBN, String titolo, int annoPubblicazione, int numeroPagine, Frequenza frequenza) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.frequenza = frequenza;
    }

    public Frequenza getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(Frequenza frequenza) {
        this.frequenza = frequenza;
    }

    @Override
    public String toString() {
        return super.toString() + " Rivista{" + "frequenza=" + frequenza + '}';
    }
}
