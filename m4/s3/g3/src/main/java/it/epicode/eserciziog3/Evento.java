package it.epicode.eserciziog3;

import it.epicode.eserciziog3.enums.TipoEvento;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "titolo", length = 50, nullable = false)
    private String titolo;

    @Column(name = "data_evento", nullable = false)
    private Date dataEvento;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    @Column(name = "descrizione", length = 100, nullable = true)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private ArrayList<Partecipazione> listaPartecipazioni;


    public Evento(){}

    public Evento(String titolo, Date dataEvento, TipoEvento tipoEvento, String descrizione, int numeroMassimoPartecipanti, Location location) {

        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.descrizione = descrizione;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento - " +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location;
    }
}
