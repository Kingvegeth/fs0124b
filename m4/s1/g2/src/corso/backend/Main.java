package corso.backend;

import java.util.Scanner;

public class Main {

    public static String input(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt + ": ");
        return sc.nextLine();

    }

    //Esercizio 1
    public static boolean stringaPariDispari(String s) {
        return s.length() % 2 == 0;
    }

    public static boolean annoBisestile(int anno) {
        return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
    }


    //Esercizio 2

    public static String maxThree(int n) {
        switch (n) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "Il numero inserito è " + n;
            default:
                return "Il numero inserito non è valido!";
        }

    }


    //Esercizio 3
    public static void splitter(String s) {
        if (!s.equals(":q")) {
        String[] charArr = s.split("");
            int i = 0;
            while (i < charArr.length - 1) {
                System.out.print(charArr[i] + ",");
            i++;
            }
            System.out.println(charArr[charArr.length-1]);
        }
    }


    //Esercizio 4
    public static void countdown(int n) {
        for (int i = n; i >= 0; i--){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {

        System.out.println("1-1: " + stringaPariDispari("pippo"));

        System.out.println("1-2: " + annoBisestile(2024));

        short n = Short.parseShort(input("2: Inserisci un numero minore o uguale a 3"));
        System.out.println(maxThree(n));

        String s = input("3: Inserisci una stringa. scrivi ':q per terminare");
        splitter(s);

        int x = Integer.parseInt(input("4: Inserisci un numero"));
        countdown(x);
    }
}