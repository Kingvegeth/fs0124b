package it.epicode.postazioni;

import it.epicode.postazioni.entities.Edificio;
import it.epicode.postazioni.entities.Postazione;
import it.epicode.postazioni.entities.Utente;
import it.epicode.postazioni.services.EdificioService;
import it.epicode.postazioni.services.PostazioneService;
import it.epicode.postazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PostazioniRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;


    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        Utente utente1 = (Utente) ctx.getBean("utente1");
        Utente utente2 = (Utente) ctx.getBean("utente2");
        Utente utente3 = (Utente) ctx.getBean("utente3");

        Edificio edificio1 = (Edificio) ctx.getBean("edificio1");
        Edificio edificio2 = (Edificio) ctx.getBean("edificio2");

        Postazione postazione1 = (Postazione) ctx.getBean("postazione1");
        Postazione postazione2 = (Postazione) ctx.getBean("postazione2");
        Postazione postazione3 = (Postazione) ctx.getBean("postazione3");
        Postazione postazione4 = (Postazione) ctx.getBean("postazione4");

        utenteService.save(utente1);
        utenteService.save(utente2);
        utenteService.save(utente3);

        edificioService.save(edificio1);
        edificioService.save(edificio2);

        postazioneService.save(postazione1);
        postazioneService.save(postazione2);
        postazioneService.save(postazione3);
        postazioneService.save(postazione4);

    }
}
