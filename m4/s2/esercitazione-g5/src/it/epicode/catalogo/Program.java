package it.epicode.catalogo;

import it.epicode.catalogo.data.Frequency;
import it.epicode.catalogo.data.Book;
import it.epicode.catalogo.data.Magazine;
import it.epicode.catalogo.services.FileLibraryService;

import java.util.Scanner;

public class Program {

    // Definizione di variabili statiche per l'utilizzo condiviso nel programma
    private static final Scanner scanner = new Scanner(System.in);
    private static final FileLibraryService library = new FileLibraryService();

    public static void main(String[] args) {
        int choice;
        do {
            choice = printMenu(); // Visualizza il menu e ottiene la scelta dell'utente
            handleMenuChoice(choice); // Gestisce la scelta dell'utente
        } while (choice != 7); // Continua fino a quando l'utente non sceglie di uscire
        scanner.close(); // Chiude lo scanner per liberare risorse
    }

    // Stampa il menu principale e ritorna la scelta dell'utente
    private static int printMenu() {
        System.out.println("\n╔═════════════════════════════════════╗");
        System.out.println("║       Catalogo della Biblioteca     ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ 1 - Cerca per ISBN                  ║");
        System.out.println("║ 2 - Cerca per anno di pubblicazione ║");
        System.out.println("║ 3 - Cerca per autore                ║");
        System.out.println("║ 4 - Elimina per ISBN                ║");
        System.out.println("║ 5 - Visualizza tutti gli articoli   ║");
        System.out.println("║ 6 - Aggiungi una pubblicazione      ║");
        System.out.println("║ 7 - " + "\033[0;33m" + "Esci" + "\033[0m" + "                            ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.print(" Seleziona un'opzione: ");
        try {
            return Integer.parseInt(scanner.nextLine()); // Ritorna il valore inserito convertito in intero
        } catch (NumberFormatException e) {
            System.out.println("Errore di input, per favore inserisci un numero valido.");
            return 0; // Gestisce l'input non valido ritornando 0
        }
    }

    // Gestisce le diverse scelte dell'utente basate sull'input del menu
    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> handleSearchByISBN();
            case 2 -> handleSearchByYear();
            case 3 -> handleSearchByAuthor();
            case 4 -> handleRemoveByISBN();
            case 5 -> handleDisplayAllPublications();
            case 6 -> addPublication();
            case 7 -> System.out.println("Uscita in corso...");
            default -> System.out.println("Opzione non valida, per favore riprova.");
        }
    }

    // Metodo per la ricerca di pubblicazioni per ISBN
    private static void handleSearchByISBN() {
        System.out.print("Inserisci ISBN: ");
        Long isbn = Long.parseLong(scanner.nextLine());
        library.findByISBN(isbn).forEach(System.out::println);
    }

    // Metodo per la ricerca di pubblicazioni per anno di pubblicazione
    private static void handleSearchByYear() {
        System.out.print("Inserisci anno di pubblicazione: ");
        int year = Integer.parseInt(scanner.nextLine());
        library.findByYear(year).forEach(System.out::println);
    }

    // Metodo per la ricerca di pubblicazioni per autore
    private static void handleSearchByAuthor() {
        System.out.print("Inserisci autore: ");
        String author = scanner.nextLine();
        library.findByAuthor(author).forEach(System.out::println);
    }

    // Metodo per eliminare una pubblicazione per ISBN
    private static void handleRemoveByISBN() {
        System.out.print("Inserisci ISBN per l'eliminazione: ");
        Long isbnToDelete = Long.parseLong(scanner.nextLine());
        library.removeByISBN(isbnToDelete);
    }

    // Metodo per visualizzare tutte le pubblicazioni nel catalogo
    private static void handleDisplayAllPublications() {
        library.getAllPublications().forEach(System.out::println);
    }

    // Metodo per aggiungere una nuova pubblicazione al catalogo
    private static void addPublication() {
        System.out.println("\nScegli il tipo di pubblicazione:");
        System.out.println("1 - Libro");
        System.out.println("2 - Rivista");
        System.out.print("Inserisci opzione: ");
        int typeChoice = Integer.parseInt(scanner.nextLine());
        switch (typeChoice) {
            case 1 -> addBook();
            case 2 -> addMagazine();
            default -> System.out.println("Scelta non valida. Per favore, inserisci 1 per Libro o 2 per Rivista.");
        }
    }

    // Metodo per aggiungere un libro al catalogo
    private static void addBook() {
        System.out.print("Inserisci Titolo: ");
        String title = scanner.nextLine();
        System.out.print("Inserisci Anno di Pubblicazione: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci Numero di Pagine: ");
        int pages = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci Autore: ");
        String author = scanner.nextLine();
        System.out.print("Inserisci Genere: ");
        String genre = scanner.nextLine();
        library.addPublication(new Book(title, year, pages, author, genre));
        System.out.println("Libro aggiunto con successo!");
    }

    // Metodo per aggiungere una rivista al catalogo
    private static void addMagazine() {
        System.out.print("Inserisci Titolo: ");
        String title = scanner.nextLine();
        System.out.print("Inserisci Anno di Pubblicazione: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci Numero di Pagine: ");
        int pages = Integer.parseInt(scanner.nextLine());
        System.out.println("Scegli la frequenza della rivista:");
        System.out.println("1 - Settimanale");
        System.out.println("2 - Mensile");
        System.out.println("3 - Semestrale");
        System.out.print("Inserisci opzione: ");
        int freqChoice = Integer.parseInt(scanner.nextLine());
        Frequency freq = switch (freqChoice) {
            case 1 -> Frequency.SETTIMANALE;
            case 2 -> Frequency.MENSILE;
            case 3 -> Frequency.SEMESTRALE;
            default -> throw new IllegalArgumentException("Opzione non valida.");
        };
        library.addPublication(new Magazine(title, year, pages, freq));
        System.out.println("Rivista aggiunta con successo!");
    }
}
