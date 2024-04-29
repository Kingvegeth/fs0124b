package it.epicode.catalogue.data;

/**
 * La classe Magazine estende la classe astratta Publication.
 * Rappresenta una rivista specifica nel catalogo della biblioteca, con informazioni sulla sua periodicità.
 */
public class Magazine extends Publication {

    private final Frequency frequency; // Campo immutabile che memorizza la periodicità della rivista

    /**
     * Costruttore per creare un'istanza di Magazine.
     *
     * @param title Il titolo della rivista.
     * @param publicationYear L'anno di pubblicazione della rivista.
     * @param pageNumber Il numero di pagine della rivista.
     * @param frequency La frequenza di pubblicazione della rivista, definita dall'enum Frequency.
     */
    public Magazine(String title, int publicationYear, int pageNumber, Frequency frequency) {
        super(title, publicationYear, pageNumber); // Chiama il costruttore della superclasse Publication
        this.frequency = frequency; // Imposta la periodicità
    }

    /**
     * Restituisce la periodicità della rivista.
     *
     * @return La periodicità come valore dell'enum Frequency.
     */
    public Frequency getFrequency() {
        return frequency;
    }

    /**
     * Override del metodo toString per fornire una rappresentazione stringa dell'oggetto Magazine.
     * Utile per la stampa diretta delle informazioni della rivista.
     *
     * @return Una stringa che rappresenta la rivista, includendo ISBN, titolo e periodicità.
     */
    @Override
    public String toString() {
        return "- RIVISTA - ISBN: " + getISBN() + ", titolo: '" + getTitle() + "', periodicità: " + getFrequency();
    }
}
