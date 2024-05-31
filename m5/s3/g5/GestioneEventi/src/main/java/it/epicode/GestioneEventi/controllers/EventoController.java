package it.epicode.GestioneEventi.controllers;

import it.epicode.GestioneEventi.entities.Evento;
import it.epicode.GestioneEventi.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ORGANIZZATORE')")
    public List<Evento> getAllEventi() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ORGANIZZATORE')")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        return eventoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ORGANIZZATORE')")
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.save(evento);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ORGANIZZATORE')")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento updatedEvento) {
        return eventoService.findById(id)
                .map(evento -> {
                    updatedEvento.setId(evento.getId());
                    return ResponseEntity.ok(eventoService.save(updatedEvento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ORGANIZZATORE')")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        if (eventoService.findById(id).isPresent()) {
            eventoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
