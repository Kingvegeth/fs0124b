package it.epicode.catalogue.data;

/**
 * La classe Book estende la classe astratta Publication.
 * Rappresenta un libro specifico nel catalogo della biblioteca, con autore e genere aggiuntivi.
 */
public class Book extends Publication {

    private final String author; // Campo che memorizza il nome dell'autore del libro
    private final String genre; // Campo che memorizza il genere letterario del libro

    /**
     * Costruttore per creare un'istanza di Libro.
     *
     * @param title Il titolo del libro.
     * @param publicationYear L'anno di pubblicazione del libro.
     * @param pageNumber Il numero di pagine del libro.
     * @param author L'autore del libro.
     * @param genre Il genere del libro.
     */
    public Book(String title, int publicationYear, int pageNumber, String author, String genre) {
        super(title, publicationYear, pageNumber); // Chiama il costruttore della superclasse Publication
        this.author = author; // Imposta l'autore del libro
        this.genre = genre; // Imposta il genere del libro
    }

    /**
     * Restituisce l'autore del libro.
     *
     * @return Il nome dell'autore.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Restituisce il genere del libro.
     *
     * @return Il genere letterario del libro.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Override del metodo toString per fornire una rappresentazione stringa dell'oggetto Book.
     * Utile per la stampa diretta delle informazioni del libro.
     *
     * @return Una stringa che rappresenta il libro, includendo ISBN, titolo, autore e genere.
     */
    @Override
    public String toString() {
        return "- LIBRO - ISBN: " + getISBN() + ", titolo: '" + getTitle() + "', autore: '" + getAuthor() + "', genere: '" + getGenre() + "'";
    }
}
