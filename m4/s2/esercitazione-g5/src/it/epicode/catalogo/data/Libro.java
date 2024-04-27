package it.epicode.catalogo.data;

public class Libro extends Pubblicazione {

    private String autore;
    private String genere;

    public Libro(Long ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "- LIBRO - ISBN: " + getISBN() +  ", titolo: '" + getTitolo() + "', autore: '" + getAutore() + "', genere: '" + getGenere() + "'";
    }
}
