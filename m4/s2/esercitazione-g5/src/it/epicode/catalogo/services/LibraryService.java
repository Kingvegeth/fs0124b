package it.epicode.catalogo.services;

import it.epicode.catalogo.data.Pubblicazione;

import java.util.List;

public interface LibraryService {


    void addPublication(Pubblicazione pubblicazione);

    void removeByISBN(Long ISBN);

    List<Pubblicazione> findByISBN(Long ISBN);

    List<Pubblicazione> findByYear(int year);

    List<Pubblicazione> findByAuthor(String author);

    List<Pubblicazione> getAllPublications();

    void save();

    void load();
}
