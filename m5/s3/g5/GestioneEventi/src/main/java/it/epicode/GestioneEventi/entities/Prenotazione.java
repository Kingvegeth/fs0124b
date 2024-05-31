package it.epicode.GestioneEventi.entities;

import jakarta.persistence.ManyToOne;

public class Prenotazione extends BaseEntity{

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Evento evento;


}
