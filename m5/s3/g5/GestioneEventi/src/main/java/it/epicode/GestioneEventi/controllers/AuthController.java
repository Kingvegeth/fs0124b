package it.epicode.GestioneEventi.controllers;

import it.epicode.GestioneEventi.config.JwtUtil;
import it.epicode.GestioneEventi.entities.Utente;
import it.epicode.GestioneEventi.models.AuthenticationRequest;
import it.epicode.GestioneEventi.models.AuthenticationResponse;
import it.epicode.GestioneEventi.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public ResponseEntity<Utente> register(@RequestBody Utente utente) {
        log.info("Registering user: {}", utente.getUsername());
        Utente savedUser = utenteService.save(utente);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        final UserDetails userDetails = utenteService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
