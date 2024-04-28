package it.epicode.catalogo.services;

import it.epicode.catalogo.data.Publication;

import java.util.List;

public interface LibraryService {


    void addPublication(Publication publication);

    void removeByISBN(Long ISBN);

    List<Publication> findByISBN(Long ISBN);

    List<Publication> findByYear(int year);

    List<Publication> findByAuthor(String author);

    List<Publication> getAllPublications();

    void save();

    void load();
}
