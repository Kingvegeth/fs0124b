package it.epicode.eserciziog3.dao;

import it.epicode.eserciziog3.Evento;
import it.epicode.eserciziog3.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EventoDao {

    private static final String PERSISTENCE_UNIT = "JPA_Sample";

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    EntityManager em = emf.createEntityManager();

    public void save(Evento e) {

        EntityTransaction trans = em.getTransaction();
        trans.begin();

        em.persist(e);
        trans.commit();

        em.close();
        emf.close();
    }

    public void saveLocation(Location location) {
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(location);
        trans.commit();
    }

    public Evento getById(Long id){
        return em.find(Evento.class, id);
    }

    public void delete(Long id){

        EntityTransaction trans = em.getTransaction();
        trans.begin();

        em.remove(getById(id));
        trans.commit();

        em.close();
        emf.close();

    }


}
