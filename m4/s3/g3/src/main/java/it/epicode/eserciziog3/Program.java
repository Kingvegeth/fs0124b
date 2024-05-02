package it.epicode.eserciziog3;

import it.epicode.eserciziog3.dao.EventoDao;
import it.epicode.eserciziog3.enums.TipoEvento;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        var eventoDAO = new EventoDao();
        var location = new Location("Nome della location", "Città della location");
        eventoDAO.saveLocation(location); // Metodo per salvare la location

        var e1 = new Evento("Titolo dell'evento", new Date(), TipoEvento.PUBBLICO, "Descrizione dell'evento", 1000, location);
        eventoDAO.save(e1);

        System.out.println(eventoDAO.getById(1L));
    }

}
