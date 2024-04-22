package it.epicode.esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Program {
    private static final Logger log = LoggerFactory.getLogger(it.epicode.esercizio1.Program.class);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int km = 0;
        int lt = 0;

        System.out.print("Inserire il numero di km percorsi: ");
        km = scanner.nextInt();
        System.out.print("Inserire il numero di litri consumati: ");
        lt = scanner.nextInt();

        try{
            if (lt==0) throw new wrongLitersException("Il numero di litri consumati non può essere uguale a 0");

        System.out.println("Hai fatto " + km/lt + "km al litro");
        } catch (wrongLitersException ex) {
            log.error(ex.getMessage());
        }

    }
}
