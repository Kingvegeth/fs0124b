package it.epicode.catalogo;

import it.epicode.catalogo.data.Frequenza;
import it.epicode.catalogo.data.Libro;
import it.epicode.catalogo.data.Rivista;
import it.epicode.catalogo.services.FileLibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileLibraryService biblioteca = new FileLibraryService();

        int choice = 0;
        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|      Catalogo della Biblioteca      |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1 - Cerca per ISBN                  |");
            System.out.println("| 2 - Cerca per anno di pubblicazione |");
            System.out.println("| 3 - Cerca per autore                |");
            System.out.println("| 4 - Elimina per ISBN                |");
            System.out.println("| 5 - Visualizza tutti gli articoli   |");
            System.out.println("| 6 - Aggiungi una pubblicazione      |");
            System.out.println("| 7 - Esci                            |");
            System.out.println("+-------------------------------------+");
            System.out.print("Seleziona un'opzione: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Inserisci ISBN: ");
                        Long isbn = Long.parseLong(scanner.nextLine());
                        biblioteca.findByISBN(isbn).forEach(System.out::println);
                        break;
                    case 2:
                        System.out.print("Inserisci anno di pubblicazione: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        biblioteca.findByYear(year).forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Inserisci autore: ");
                        String author = scanner.nextLine();
                        biblioteca.findByAuthor(author).forEach(System.out::println);
                        break;
                    case 4:
                        System.out.print("Inserisci ISBN per l'eliminazione: ");
                        Long isbnToDelete = Long.parseLong(scanner.nextLine());
                        biblioteca.removeByISBN(isbnToDelete);
                        System.out.println("Pubblicazione eliminata.");
                        break;
                    case 5:
                        biblioteca.getAllPublications().forEach(System.out::println);
                        break;
                    case 6:
                        addPublication(scanner, biblioteca);
                        break;
                    case 7:
                        System.out.println("Uscita in corso...");
                        break;
                    default:
                        System.out.println("Opzione non valida, per favore riprova.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore di input, per favore inserisci un numero valido.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void addPublication(Scanner scanner, FileLibraryService biblioteca) {
        System.out.print("Inserisci 'libro' o 'rivista': ");
        String type = scanner.nextLine().toLowerCase();
        if ("libro".equals(type)) {
            addBook(scanner, biblioteca);
        } else if ("rivista".equals(type)) {
            addMagazine(scanner, biblioteca);
        } else {
            System.out.println("Tipo non valido. Inserisci 'libro' o 'rivista'.");
        }
    }

    private static void addBook(Scanner scanner, FileLibraryService biblioteca) {
        System.out.print("Inserisci ISBN: ");
        Long isbn = Long.parseLong(scanner.nextLine());
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
        biblioteca.addPublication(new Libro(isbn, title, year, pages, author, genre));
        System.out.println("Libro aggiunto con successo!");
    }

    private static void addMagazine(Scanner scanner, FileLibraryService biblioteca) {
        System.out.print("Inserisci ISBN: ");
        Long isbn = Long.parseLong(scanner.nextLine());
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
        Frequenza freq = switch (freqChoice) {
            case 1 -> Frequenza.SETTIMANALE;
            case 2 -> Frequenza.MENSILE;
            case 3 -> Frequenza.SEMESTRALE;
            default -> throw new IllegalArgumentException("Opzione non valida.");
        };
        biblioteca.addPublication(new Rivista(isbn, title, year, pages, freq));
        System.out.println("Rivista aggiunta con successo!");
    }
}
