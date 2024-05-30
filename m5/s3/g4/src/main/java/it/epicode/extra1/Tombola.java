package it.epicode.extra1;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Tombola {

    private static Set<Integer> numeriEstratti = new LinkedHashSet<>();
    private static Random random = new Random();

    public static int estraiNumero() {
        int numero;
        do {
            numero = random.nextInt(90) + 1;
        } while (numeriEstratti.contains(numero));

        numeriEstratti.add(numero);
        return numero;
    }

    public static void estraiNumeriTombola() {
        numeriEstratti.clear();
        System.out.println("Estrazione dei numeri della tombola:");
        for (int i = 0; i < 90; i++) {
            int numero = estraiNumero();
            System.out.println("Numero estratto: " + numero);
        }
        System.out.println("Tutti i numeri estratti: " + numeriEstratti);
    }

}
