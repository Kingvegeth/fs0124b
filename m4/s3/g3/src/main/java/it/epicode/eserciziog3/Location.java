package it.epicode.eserciziog3;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "città", length = 50, nullable = false)
    private String citta;


    public Location(){}

    public Location(String nome, String citta) {

        this.nome = nome;
        this.citta = citta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittà() {
        return citta;
    }

    public void setCittà(String città) {
        this.citta = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + citta + '\'' +
                '}';
    }
}
