import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static  String input(String prompt){
        Scanner sc = new Scanner(System.in);
            System.out.print(prompt + ": ");
            return sc.nextLine();

    }
    public static Integer inputInteger(String prompt){
        Scanner sc = new Scanner(System.in);
            System.out.print(prompt + ": ");
            return sc.nextInt();
    }
    public static Double inputDouble(String prompt){
        Scanner sc = new Scanner(System.in);
            System.out.print(prompt + ": ");
            return sc.nextDouble();
    }

    public static int moltiplica(int a, int b){
        return a * b;
    }

    public static String concatena(String stringa, int n) {
        return stringa + n;
    }

    public static String[] inserisciInArray(String[] strArr,String stringa) {
        String[] nuovoArr = {strArr[0],strArr[1],strArr[2],stringa,strArr[3],strArr[4]};
        return nuovoArr;
    }

    public static void stringOrder(String stringa1, String stringa2) {
        String normale = stringa1 + stringa2;
        String inverso = stringa2 + stringa1;
        System.out.println("Concatenazione normale: " + normale);
        System.out.println("Concatenazione inversa: " + inverso);
    }


    public static void main(String[] args){
        String[] array = { "primo", "secondo", "terzo", "quarto", "quinto"};

        System.out.println("Esercizio 1 - 1: " + moltiplica(2, 5));
        System.out.println("Esercizio 1 - 2: " + concatena("pippo", 5));
        System.out.println("Esercizio 1 - 3: " + Arrays.toString(inserisciInArray(array, "pippo")));


        String s1 = input("Inserisci la prima stringa");
        String s2 = input("Inserisci la seconda stringa");
        stringOrder(s1, s2);


    }


}
