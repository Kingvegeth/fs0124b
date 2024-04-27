package it.epicode.catalogo.services;

import it.epicode.catalogo.data.Frequenza;
import it.epicode.catalogo.data.Libro;
import it.epicode.catalogo.data.Pubblicazione;
import it.epicode.catalogo.data.Rivista;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileLibraryService implements LibraryService{

    private static final Logger logger = LoggerFactory.getLogger(FileLibraryService.class);
    private static final String STORAGE = "./library.csv";

    private final ArrayList<Pubblicazione> biblioteca = new ArrayList<>();

    public FileLibraryService() {
        load();
    }

    @Override
    public void addPublication(Pubblicazione pubblicazione) {
        biblioteca.add(pubblicazione);
        save();
    }

    @Override
    public void removeByISBN(Long ISBN) {
        biblioteca.removeIf(p -> p.getISBN().equals(ISBN));
        save();
    }

    @Override
    public List<Pubblicazione> findByISBN(Long ISBN) {
        return biblioteca.stream()
                .filter(p -> p.getISBN().equals(ISBN))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pubblicazione> findByYear(int year) {
        return biblioteca.stream()
                .filter(p -> p.getAnnoPubblicazione() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pubblicazione> findByAuthor(String author) {
        return biblioteca.stream()
                .filter(p -> p instanceof Libro && ((Libro) p).getAutore().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pubblicazione> getAllPublications() {
        return new ArrayList<>(biblioteca);
    }

    @Override
    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.write(f, "", StandardCharsets.ISO_8859_1);
            for (Pubblicazione p : biblioteca) {
                List<String> lines = new ArrayList<>();
                lines.add(p.getClass().getSimpleName());
                lines.add(p.getISBN().toString());
                lines.add(p.getTitolo());
                lines.add(String.valueOf(p.getAnnoPubblicazione()));
                lines.add(String.valueOf(p.getNumeroPagine()));
                if (p instanceof Libro) {
                    Libro l = (Libro) p;
                    lines.add(l.getAutore());
                    lines.add(l.getGenere());
                } else if (p instanceof Rivista) {
                    Rivista r = (Rivista) p;
                    lines.add(r.getFrequenza().toString());
                }
                FileUtils.writeStringToFile(f, String.join(",", lines) + System.lineSeparator(), StandardCharsets.ISO_8859_1, true);
            }
        } catch (IOException e) {
            logger.error("Errore durante il salvataggio", e);
        }
    }

    @Override
    public void load() {
        File f = new File(STORAGE);
        if (!f.exists()) return; // Se il file non esiste, termina il caricamento

        try {
            List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length < 2) { // Il programma si assicura che ci siano almeno due elementi
                    logger.error("Riga non valida o incompleta: " + line);
                    continue; // Salta questa iterazione e continua con la prossima riga
                }
                Long ISBN = Long.parseLong(parts[1]);
                String titolo = parts[2];
                int annoPubblicazione = Integer.parseInt(parts[3]);
                int numeroPagine = Integer.parseInt(parts[4]);
                if ("Libro".equals(parts[0]) && parts.length >= 7) {
                    String autore = parts[5];
                    String genere = parts[6];
                    biblioteca.add(new Libro(ISBN, titolo, annoPubblicazione, numeroPagine, autore, genere));
                } else if ("Rivista".equals(parts[0]) && parts.length >= 6) {
                    Frequenza frequenza = Frequenza.valueOf(parts[5]);
                    biblioteca.add(new Rivista(ISBN, titolo, annoPubblicazione, numeroPagine, frequenza));
                }
            }
        } catch (IOException e) {
            logger.error("Errore durante il caricamento", e);
        }
    }
}