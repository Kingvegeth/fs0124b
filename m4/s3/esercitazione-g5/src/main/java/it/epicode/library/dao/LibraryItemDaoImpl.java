package it.epicode.library.dao;

import it.epicode.library.entities.Book;
import it.epicode.library.entities.LibraryItem;
import it.epicode.library.entities.Magazine;
import it.epicode.library.entities.enums.Frequency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class LibraryItemDaoImpl implements LibraryItemDao {

    private static final Logger log = LoggerFactory.getLogger(LibraryItemDaoImpl.class);

    private static final String PERSISTENCE_UNIT = "JPA_Sample";
    private final EntityManager em;

    public LibraryItemDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    @Override
    public boolean isValidIsbn(String code) {
        code = code.replace("-", "");
        switch (code.length()) {
            case 10:
                return checkIsbn10(code);
            case 13:
                return checkIsbn13(code);
            default:
                return false;
        }
    }

    private boolean checkIsbn10(String code) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(code.charAt(i));
            sum += (i + 1) * digit;
        }
        char lastChar = code.charAt(9);
        int lastDigit = (lastChar == 'X') ? 10 : Character.getNumericValue(lastChar);
        sum += 10 * lastDigit;
        return sum % 11 == 0;
    }

    private boolean checkIsbn13(String code) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(code.charAt(i));
            sum += (i % 2 == 0) ? digit : 3 * digit;
        }
        int lastDigit = Character.getNumericValue(code.charAt(12));
        return (10 - (sum % 10)) % 10 == lastDigit;
    }

    @Override
    public void addItem(LibraryItem item) {
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void removeItemByISBN(String isbn) {
        try {
            em.getTransaction().begin();
            LibraryItem item = getItemByISBN(isbn);
            if (item != null) {
                em.remove(item);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public LibraryItem getItemByISBN(String isbn) {
        try {
            return em.createQuery("SELECT i FROM LibraryItem i WHERE i.isbn = :isbn", LibraryItem.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<LibraryItem> getItemsByPublicationYear(int publicationYear) {
        return em.createQuery("SELECT i FROM LibraryItem i WHERE i.publicationYear = :publicationYear", LibraryItem.class)
                .setParameter("publicationYear", publicationYear)
                .getResultList();
    }

    @Override
    public List<LibraryItem> getItemsByAuthor(String author) {
        return em.createQuery("SELECT b FROM Book b WHERE LOWER(b.author) LIKE LOWER(:author)", LibraryItem.class)
                .setParameter("author", "%" + author.toLowerCase() + "%")
                .getResultList();
    }

    @Override
    public List<LibraryItem> getItemsByTitle(String title) {
        return em.createQuery("SELECT i FROM LibraryItem i WHERE LOWER(i.title) LIKE LOWER(:title)", LibraryItem.class)
                .setParameter("title", "%" + title.toLowerCase() + "%")
                .getResultList();
    }


    private Book createBook(Scanner scanner, String isbn, String title, int publicationYear, int pages) {
        System.out.print("Autore: ");
        String author = scanner.nextLine();
        System.out.print("Genere: ");
        String genre = scanner.nextLine();
        return new Book(isbn, title, publicationYear, pages, author, genre);
    }

    private Magazine createMagazine(Scanner scanner, String isbn, String title, int publicationYear, int pages) {
        System.out.println("Seleziona la periodicità:");
        for (Frequency frequency : Frequency.values()) {
            System.out.println(frequency.ordinal() + 1 + ". " + frequency);
        }
        System.out.print("Scelta: ");
        int frequencyChoice = scanner.nextInt();
        Frequency frequency = Frequency.values()[frequencyChoice - 1];
        return new Magazine(isbn, title, publicationYear, pages, frequency);
    }
}
