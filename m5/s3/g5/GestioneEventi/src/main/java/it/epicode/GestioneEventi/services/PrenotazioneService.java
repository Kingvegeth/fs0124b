package it.epicode.GestioneEventi.services;

import it.epicode.GestioneEventi.entities.Prenotazione;
import it.epicode.GestioneEventi.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> findById(Long id) {
        return prenotazioneRepository.findById(id);
    }

    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public void deleteById(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
