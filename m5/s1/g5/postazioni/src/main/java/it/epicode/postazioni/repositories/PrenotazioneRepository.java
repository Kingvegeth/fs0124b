package it.epicode.postazioni.repositories;

import it.epicode.postazioni.entities.Postazione;
import it.epicode.postazioni.entities.Prenotazione;
import it.epicode.postazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

}
