package it.epicode.eserciziog2;

import java.util.Date;

public class Program {

    public static void main(String[] args){

        var eventoDAO = new EventoDAO();
        var e1 = new Evento(1L, "Suicidio di massa", new Date(), TipoEvento.PUBBLICO, "Basta con Java, Accogliamo la pace eterna!", 1000);

        eventoDAO.save(e1);

        System.out.println(eventoDAO.getById(1L));


    }

}
