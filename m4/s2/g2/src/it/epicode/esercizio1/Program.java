package it.epicode.esercizio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quanti elementi vuoi inserire? : ");
        int n = sc.nextInt();
        sc.nextLine();

        var s = new HashSet<String>();
        var dup = new ArrayList<String>();

        for (int i = 0; i< n; i++){
            System.out.print("Inserisci la parola n."+ (i+1) +" : ");
            String word = sc.nextLine();
            if (s.add(word)) s.add(word);
            else dup.add(word);
        }

        System.out.println("Parole duplicate: " + dup);
        System.out.println("N. di parole distinte: "+ s.size());
        System.out.println("Parole distinte: " + s);
    }

}
