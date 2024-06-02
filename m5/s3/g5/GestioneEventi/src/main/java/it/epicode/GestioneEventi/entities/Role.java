package it.epicode.GestioneEventi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {

    @EqualsAndHashCode.Include
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Utente> users;
}
