package it.epicode.catalogo;

import it.epicode.catalogo.data.Frequenza;
import it.epicode.catalogo.data.Libro;

import it.epicode.catalogo.data.Rivista;
import it.epicode.catalogo.services.FileLibraryService;



public class Main {


    public static void main(String[] args) {

        FileLibraryService biblioteca = new FileLibraryService();


        biblioteca.addPublication(new Libro(123456789L, "Inferno", 1314, 1000, "Dante Alighieri", "Classico"));
        biblioteca.addPublication(new Rivista(987654321L, "Il tuo Idropene e altri modi per divertirsi", 2024, 69, Frequenza.MENSILE));
        biblioteca.save();


        Long ISBNToSearch = 987654321L;
        int yearToSearch = 1314;
        String authorToSearch = "Dante Alighieri";

        var ISBNTrovato = biblioteca.findByISBN(ISBNToSearch);
        var annoTrovato = biblioteca.findByYear(yearToSearch);
        var autoreTrovato = biblioteca.findByAuthor(authorToSearch);

        // Rimozione di un elemento a partire da ISBN
        biblioteca.removePublicationByISBN(ISBNToSearch);

        // Stampa dei risultati
        ISBNTrovato.forEach(p -> System.out.println("L'articolo con ISBN " + ISBNToSearch + " è '" + p.getTitolo() + "'"));
        System.out.format("%nTrovati " + annoTrovato.size() + " articoli pubblicati nel " + yearToSearch + ":%n");
        annoTrovato.forEach(p -> System.out.println("-" + p.getTitolo()));

        System.out.format("%nLibri trovati dell'autore " + authorToSearch + ":%n");
        autoreTrovato.forEach(p -> System.out.println("-" + p.getTitolo()));

    }

}