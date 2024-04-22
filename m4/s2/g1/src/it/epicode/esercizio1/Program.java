package it.epicode.esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final Logger log = LoggerFactory.getLogger(Program.class);



    public static void main(String[] args) {

        Random rnd = new Random();
        int[] arr = rnd.ints(5, 1, 11).toArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(arr));
            while (true) {
                System.out.print("Che posizione vuoi modificare? (1-5): ");
                int pos = scanner.nextInt();
                if (pos == 0) break;
                try {
                    if (pos < 1 || pos > 5) throw new wrongArrayPositionException("La posizione inserita non è valida. Deve essere tra 1 e 5.");
                    System.out.print("Inserisci un nuovo numero in posizione " + pos + ": ");
                    int n = scanner.nextInt();
                    arr[pos - 1] = n;
                    System.out.println("Array aggiornato: " + Arrays.toString(arr));
                } catch (wrongArrayPositionException ex) {
                    log.error(ex.getMessage());
                }
            }

    }

}
