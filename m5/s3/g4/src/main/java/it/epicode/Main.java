package it.epicode;

import it.epicode.extra1.Tombola;
import it.epicode.extra2.Carta;
import it.epicode.extra2.Mazzo;

import java.util.Scanner;

public class Main {

    public static void giochiCarte(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Mazzo mazzo = new Mazzo();

        while (!exit) {
            System.out.println("\nMenu Carte:");
            System.out.println("1. Mescola mazzo");
            System.out.println("2. Distribuisci carta");
            System.out.println("3. Mostra mazzo");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    mazzo.mischia();
                    break;
                case 2:
                        System.out.println("Carta distribuita: " + mazzo.distribuisci());
                    break;
                case 3:
                    System.out.println(mazzo);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Estrai numeri della tombola");
            System.out.println("2. Carte");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    Tombola.estraiNumeriTombola();
                    break;
                case 2:
                    giochiCarte();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}
