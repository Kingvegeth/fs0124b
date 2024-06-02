package it.epicode.GestioneEventi.controllers;

import it.epicode.GestioneEventi.entities.Role;
import it.epicode.GestioneEventi.entities.Utente;
import it.epicode.GestioneEventi.services.RoleService;
import it.epicode.GestioneEventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/addRole")
    public ResponseEntity<String> addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        Utente utente = utenteService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleService.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        utente.getRoles().add(role);
        utenteService.saveWithoutPasswordEncoding(utente);
        return ResponseEntity.ok("Role added to user successfully");
    }
}
