package it.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static Rubrica trovaDaNumero(Map<String, Rubrica> rubrica, String telefono) {
        for (Map.Entry<String, Rubrica> entry : rubrica.entrySet()) {
            if (entry.getValue().getTelefono().equals(telefono)) {
                return entry.getValue();
            }
        }
        System.out.println("Nessun contatto trovato con il numero " + telefono);
        return null;
    }

    public static void stampaRubrica(Map<String, Rubrica> rubrica) {
        System.out.println();
        System.out.println("LISTA DEI CONTATTI IN RUBRICA");
        for (Rubrica c : rubrica.values()) {
            System.out.println(c);
        }
        System.out.println();
    }


    public static void main(String[] args){

        Map<String, Rubrica> rubrica = new HashMap<>();
        rubrica.put("Luigi", new Rubrica("Luigi", "3451661778"));
        rubrica.put("Danilo", new Rubrica("Danilo", "3471451229"));
        rubrica.put("Simone", new Rubrica("Simone", "3496666666"));
        rubrica.put("Francesca", new Rubrica("Francesca", "3481234567"));
        rubrica.put("Chiara", new Rubrica("Chiara", "3451122334"));
        rubrica.put("Andrea", new Rubrica("Alessandro", "3498765432"));
        rubrica.put("Sara", new Rubrica("Sara", "3475647382"));

        stampaRubrica(rubrica);

        Scanner sc = new Scanner(System.in);

        System.out.print("Inserire nome del contatto da eliminare: ");
        String nomeDaEliminare = sc.nextLine();
        rubrica.remove(nomeDaEliminare);

        stampaRubrica(rubrica);

        System.out.print("Inserire numero del contatto da cercare: ");
        String numeroDaCercare = sc.nextLine();
        if (trovaDaNumero(rubrica, numeroDaCercare) != null) System.out.println(trovaDaNumero(rubrica, numeroDaCercare));

        System.out.print("Inserire nome del contatto da cercare: ");
        String nomeDaCercare = sc.nextLine();

        if(rubrica.get(nomeDaCercare) != null) System.out.println(rubrica.get(nomeDaCercare));
        else System.out.println("Nessun contatto trovato con il nome " + nomeDaCercare);

    }


}
