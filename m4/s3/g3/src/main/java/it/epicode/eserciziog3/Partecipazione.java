package it.epicode.eserciziog3;

import it.epicode.eserciziog3.enums.StatoPartecipazione;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    public Partecipazione(){}

    public Partecipazione(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
        this.stato = StatoPartecipazione.DA_CONFERMARE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
