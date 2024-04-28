package it.epicode.catalogue.services;

import it.epicode.catalogue.data.Publication;
import java.util.List;

/**
 * Interfaccia LibraryService che definisce le operazioni per la gestione delle pubblicazioni
 * in una biblioteca. Include metodi per l'aggiunta, la rimozione, la ricerca e la visualizzazione
 * delle pubblicazioni, oltre alla persistenza dei dati.
 */
public interface LibraryService {

    /**
     * Aggiunge una pubblicazione al catalogo della biblioteca.
     *
     * @param publication La pubblicazione da aggiungere.
     */
    void addPublication(Publication publication);

    /**
     * Rimuove una pubblicazione dal catalogo della biblioteca usando il suo ISBN.
     *
     * @param ISBN L'ISBN della pubblicazione da rimuovere.
     */
    void removeByISBN(Long ISBN);

    /**
     * Cerca e restituisce tutte le pubblicazioni con l'ISBN specificato.
     *
     * @param ISBN L'ISBN da cercare.
     * @return Una lista di pubblicazioni che corrispondono all'ISBN fornito.
     */
    List<Publication> findByISBN(Long ISBN);

    /**
     * Cerca e restituisce tutte le pubblicazioni pubblicate in un determinato anno.
     *
     * @param year L'anno di pubblicazione per il quale cercare.
     * @return Una lista di pubblicazioni pubblicate nell'anno specificato.
     */
    List<Publication> findByYear(int year);

    /**
     * Cerca e restituisce tutte le pubblicazioni di un determinato autore.
     *
     * @param author L'autore delle pubblicazioni da cercare.
     * @return Una lista di pubblicazioni scritte dall'autore specificato.
     */
    List<Publication> findByAuthor(String author);

    /**
     * Restituisce tutte le pubblicazioni presenti nel catalogo della biblioteca.
     *
     * @return Una lista di tutte le pubblicazioni disponibili.
     */
    List<Publication> getAllPublications();

    /**
     * Salva lo stato attuale del catalogo delle pubblicazioni, permettendo la persistenza dei dati.
     * Questo metodo è essenziale per mantenere aggiornato il catalogo dopo modifiche come aggiunte, rimozioni o aggiornamenti.
     */
    void save();

    /**
     * Carica lo stato del catalogo delle pubblicazioni, inizializzando il sistema con i dati salvati.
     * Questo metodo è fondamentale per ripristinare il catalogo al suo ultimo stato salvato all'avvio del sistema.
     */
    void load();
}



