package it.epicode.GestioneEventi.controllers;

import it.epicode.GestioneEventi.entities.Utente;
import it.epicode.GestioneEventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('USER') or hasRole('ORGANIZZATORE')")
    public ResponseEntity<Utente> getUtenteByUsername(@PathVariable String username) {
        return utenteService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utente createUtente(@RequestBody Utente utente) {
        return utenteService.save(utente);
    }
}
