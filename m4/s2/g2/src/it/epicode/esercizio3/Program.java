package it.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {



    public static void main(String[] args){

        Map<String, Rubrica> rubrica = new HashMap<>();
        rubrica.put("Luigi", new Rubrica("Luigi","3451661778"));
        rubrica.put("Danilo", new Rubrica("Danilo","3471451229"));
        rubrica.put("Simone", new Rubrica("Simone","3496666666"));

        System.out.println();
        System.out.println("LISTA DEI CONTATTI IN RUBRICA");
        for (var c : rubrica.values()){
            System.out.println(c);
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Inserire nome del contatto da eliminare: ");

        String contattoDaEliminare = sc.nextLine();
        rubrica.remove(contattoDaEliminare);

        System.out.println();
        System.out.println("LISTA DEI CONTATTI IN RUBRICA");
        for (var c : rubrica.values()){
            System.out.println(c);
        }


    }


}
