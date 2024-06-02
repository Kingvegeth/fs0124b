package it.epicode.GestioneEventi.runners;

import it.epicode.GestioneEventi.entities.Role;
import it.epicode.GestioneEventi.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!roleRepository.findByName("USER").isPresent()) {
            Role userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }
        if (!roleRepository.findByName("ORGANIZZATORE").isPresent()) {
            Role organizzatoreRole = new Role();
            organizzatoreRole.setName("ORGANIZZATORE");
            roleRepository.save(organizzatoreRole);
        }
    }
}
