package it.epicode.g3.es2;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public class CompositeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("************************** COMPOSITE ************************");
        Faker faker = new Faker(Locale.ITALY);
        Page pag1 = new Page(1, faker.harryPotter().quote());
        Page pag2 = new Page(2, faker.harryPotter().quote());
        Page pag3 = new Page(3, faker.harryPotter().quote());
        Page pag4 = new Page(4, faker.harryPotter().quote());
        Page pag5 = new Page(5, faker.harryPotter().quote());
        Page pag6 = new Page(6, faker.harryPotter().quote());
        Page pag7 = new Page(7, faker.harryPotter().quote());
        Page pag8 = new Page(8, faker.harryPotter().quote());
        Page pag9 = new Page(9, faker.harryPotter().quote());
        Page pag10 = new Page(10, faker.harryPotter().quote());

        Sezione sottocapitolo1 = new Sezione("Sottocapitolo 1",Arrays.asList(pag1, pag2));
        Sezione sottocapitolo2 = new Sezione("Sottocapitolo 2",Arrays.asList(pag3, pag4));
        Sezione sottocapitolo3 = new Sezione("Sottocapitolo 3",Arrays.asList(pag5, pag6));
        Sezione sottocapitolo4 = new Sezione("Sottocapitolo 4",Arrays.asList(pag7, pag8));
        Sezione sottocapitolo5 = new Sezione("Sottocapitolo 5",Arrays.asList(pag9, pag10));

        Sezione capitolo1 = new Sezione("Capitolo 1", Arrays.asList(sottocapitolo1, sottocapitolo2));
        Sezione capitolo2 = new Sezione("Capitolo 2",Arrays.asList(sottocapitolo3, sottocapitolo4, sottocapitolo5));

        Libro libro = new Libro(faker.harryPotter().book(), Arrays.asList(capitolo1, capitolo2), 20.0, Arrays.asList(faker.harryPotter().character(), faker.harryPotter().character(), faker.harryPotter().character()));
        libro.stampa();
        System.out.println("Il libro " + libro.getTitolo() + " ha " + libro.getNumeroPagine() + " pagine");

    }
}
