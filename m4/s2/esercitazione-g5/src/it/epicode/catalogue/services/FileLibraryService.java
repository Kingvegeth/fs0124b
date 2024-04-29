package it.epicode.catalogue.services;
import it.epicode.catalogue.data.Book;
import it.epicode.catalogue.data.Frequency;
import it.epicode.catalogue.data.Publication;
import it.epicode.catalogue.data.Magazine;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FileLibraryService implements LibraryService {

    private static final Logger logger = LoggerFactory.getLogger(FileLibraryService.class);
    private static final String STORAGE = "./library.csv"; // Percorso del file CSV dove verranno salvate le pubblicazioni
    private static Long nextISBN = 100000000L; // ISBN iniziale, incrementato ogni volta che una pubblicazione è aggiunta

    private final ArrayList<Publication> library = new ArrayList<>(); // Lista che tiene traccia di tutte le pubblicazioni

    public FileLibraryService() {
        load(); // Carica le pubblicazioni dal file CSV all'avvio del servizio
    }

    @Override
    public void addPublication(Publication publication) {
        publication.setISBN(nextISBN++); // Assegna un ISBN univoco e incrementa per il prossimo uso
        library.add(publication); // Aggiunge la nuova pubblicazione alla lista
        save(); // Salva lo stato attuale della biblioteca nel file CSV
    }

    @Override
    public void removeByISBN(Long ISBN) {
        boolean found = false; // Flag per verificare se l'ISBN è stato trovato
        Iterator<Publication> iterator = library.iterator();
        while (iterator.hasNext()) {
            Publication publication = iterator.next();
            if (publication.getISBN().equals(ISBN)) {
                iterator.remove(); // Rimuove la pubblicazione se l'ISBN corrisponde
                found = true;
                save(); // Salva le modifiche
                System.out.println("Pubblicazione '" + publication.getTitle() + "' eliminata con successo.");
                break;
            }
        }
        if (!found) {
            System.out.println("ISBN " + ISBN + " non trovato nel catalogo.");
        }
    }

    @Override
    public List<Publication> findByISBN(Long ISBN) {
        List<Publication> results = library.stream()
                .filter(p -> p.getISBN().toString().endsWith(ISBN.toString())) // Cerca pubblicazioni che corrispondano all'ISBN
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("ISBN " + ISBN + " non trovato nel catalogo.");
        }
        return results;
    }

    @Override
    public List<Publication> findByYear(int year) {
        List<Publication> results = library.stream()
                .filter(p -> p.getPublicationYear() == year) // Filtra le pubblicazioni per anno di pubblicazione
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("Nessun articolo pubblicato nell'anno '" + year + "' trovato nel catalogo.");
        }
        return results;
    }

    @Override
    public List<Publication> findByAuthor(String author) {
        String authorLower = author.toLowerCase(); // Ignora il case dell'autore per la ricerca
        List<Publication> results = library.stream()
                .filter(p -> p instanceof Book && ((Book) p).getAuthor().toLowerCase().contains(authorLower)) // Cerca autori contenenti la stringa fornita
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("Nessuna pubblicazione di '" + author + "' trovata nel catalogo.");
        }
        return results;
    }

    @Override
    public List<Publication> getAllPublications() {
        if (library.isEmpty()) {
            System.out.println("Nessuna pubblicazione nel catalogo."); // Controlla se la biblioteca è vuota
            return new ArrayList<>();
        }
        return new ArrayList<>(library);
    }

    @Override
    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.write(f, "", StandardCharsets.ISO_8859_1); // Pulisce il file prima di scrivere
            for (Publication p : library) {
                List<String> lines = new ArrayList<>();
                lines.add(p.getClass().getSimpleName());
                lines.add("\"" + p.getISBN().toString() + "\"");
                lines.add("\"" + p.getTitle() + "\"");
                lines.add("\"" + p.getPublicationYear() + "\"");
                lines.add("\"" + p.getPageNumber() + "\"");
                if (p instanceof Book l) {
                    lines.add("\"" + l.getAuthor() + "\"");
                    lines.add("\"" + l.getGenre() + "\"");
                } else if (p instanceof Magazine r) {
                    lines.add("\"" + r.getFrequency().toString() + "\"");
                }
                FileUtils.writeStringToFile(f, String.join(",", lines) + System.lineSeparator(), StandardCharsets.ISO_8859_1, true); // Scrive ogni pubblicazione in una nuova riga nel file CSV
            }
        } catch (IOException e) {
            logger.error("Errore durante il salvataggio", e);
        }
    }

    @Override
    public void load() {
        File f = new File(STORAGE);
        if (!f.exists()) {
            logger.info("File di storage non trovato, inizializzazione nuova biblioteca");
            nextISBN = 100000000L; // Imposta un nuovo ISBN base se il file non esiste
            return;
        }

        long maxISBN = 100000000L;

        try {
            List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
            for (String line : lines) {
                // Questa espressione regolare gestisce le virgole all'interno di testi racchiusi tra virgolette
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (parts.length < 5) {
                    logger.error("Riga non valida o incompleta: {}", line);
                    continue;
                }

                try {
                    long ISBN = Long.parseLong(parts[1].replaceAll("\"", "").trim());
                    String title = parts[2].replaceAll("\"", "").trim();
                    int yearPublished = Integer.parseInt(parts[3].replaceAll("\"", "").trim());
                    int pageCount = Integer.parseInt(parts[4].replaceAll("\"", "").trim());

                    if ("Book".equals(parts[0].replaceAll("\"", "").trim())) {
                        if (parts.length < 7) {
                            logger.error("Informazioni insufficienti per creare un libro: {}", line);
                            continue;
                        }
                        String author = parts[5].replaceAll("\"", "").trim();
                        String genre = parts[6].replaceAll("\"", "").trim();
                        Book book = new Book(title, yearPublished, pageCount, author, genre);
                        book.setISBN(ISBN);
                        library.add(book);
                    } else if ("Magazine".equals(parts[0].replaceAll("\"", "").trim())) {
                        if (parts.length < 6) {
                            logger.error("Informazioni insufficienti per creare una rivista: {}", line);
                            continue;
                        }
                        Frequency frequency = Frequency.valueOf(parts[5].replaceAll("\"", "").trim());
                        Magazine magazine = new Magazine(title, yearPublished, pageCount, frequency);
                        magazine.setISBN(ISBN);
                        library.add(magazine);
                    } else {
                        logger.error("Tipo di pubblicazione non riconosciuto: {}", line);
                        continue;
                    }

                    if (ISBN > maxISBN) {
                        maxISBN = ISBN;
                    }
                } catch (NumberFormatException e) {
                    logger.error("Errore nel parsing dei numeri: {}", line, e);
                }
            }

            nextISBN = maxISBN + 1; // Aggiorna il prossimo ISBN disponibile
        } catch (IOException e) {
            logger.error("Errore durante il caricamento", e);
        }
    }


}
