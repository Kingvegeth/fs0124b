package it.epicode.postazioni.services;

import it.epicode.postazioni.entities.Prenotazione;
import it.epicode.postazioni.exceptions.NotFoundException;
import it.epicode.postazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAll() { return prenotazioneRepository.findAll(); }

    public Prenotazione findById(long id) { return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));}

    public void save(Prenotazione prenotazione) { prenotazioneRepository.save(prenotazione); }

    public void findByIdAndDelete(Long id) {
        Prenotazione prenotazione = this.findById(id);
        prenotazioneRepository.delete(prenotazione);
    }


}
