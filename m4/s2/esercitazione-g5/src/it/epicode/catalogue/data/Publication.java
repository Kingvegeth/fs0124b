package it.epicode.catalogue.data;

/**
 * Classe astratta che rappresenta una pubblicazione generica in un sistema di catalogazione bibliotecaria.
 * Questa classe fornisce la struttura di base per diversi tipi di pubblicazioni come libri e riviste.
 */
public abstract class Publication {

    private Long ISBN; // Identificatore unico per ogni pubblicazione
    private final String title; // Titolo della pubblicazione, immutabile dopo la creazione
    private final int publicationYear; // Anno di pubblicazione della pubblicazione, immutabile
    private final int pageNumber; // Numero di pagine della pubblicazione, immutabile

    /**
     * Costruttore per creare una nuova pubblicazione.
     *
     * @param title Il titolo della pubblicazione.
     * @param publicationYear L'anno in cui la pubblicazione è stata pubblicata.
     * @param pageNumber Il numero di pagine della pubblicazione.
     */
    public Publication(String title, int publicationYear, int pageNumber) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumber = pageNumber;
    }

    /**
     * Restituisce l'ISBN della pubblicazione.
     *
     * @return L'ISBN come Long.
     */
    public Long getISBN() {
        return ISBN;
    }

    /**
     * Imposta l'ISBN della pubblicazione.
     *
     * @param ISBN Il nuovo ISBN da assegnare alla pubblicazione.
     */
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Restituisce il titolo della pubblicazione.
     *
     * @return Il titolo come stringa.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Restituisce l'anno di pubblicazione.
     *
     * @return L'anno di pubblicazione come intero.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Restituisce il numero di pagine della pubblicazione.
     *
     * @return Il numero di pagine come intero.
     */
    public int getPageNumber() {
        return pageNumber;
    }

}
