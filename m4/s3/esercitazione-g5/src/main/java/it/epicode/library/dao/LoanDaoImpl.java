package it.epicode.library.dao;

import it.epicode.library.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LoanDaoImpl implements LoanDao{


    private static final String PERSISTENCE_UNIT = "JPA_Sample";
    private EntityManagerFactory emf;
    private EntityManager em;

    public LoanDaoImpl() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    @Override
    public List<Loan> getLoansByUserTessera(int tesseraNumber) {
        return em.createQuery("SELECT l FROM Loan l WHERE l.user.numeroTessera = :tesseraNumber", Loan.class)
                .setParameter("tesseraNumber", tesseraNumber)
                .getResultList();
    }

    @Override
    public List<Loan> getOverdueLoans() {
        return em.createQuery("SELECT l FROM Loan l WHERE l.dataRestituzionePrevista < CURRENT_DATE AND l.dataRestituzioneEffettiva IS NULL", Loan.class)
                .getResultList();
    }

}
