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
        return new String[]{strArr[0], strArr[1], strArr[2], stringa, strArr[3], strArr[4]};

    }

    public static void stringOrder(String stringa1, String stringa2) {
        String normale = stringa1 + stringa2;
        String inverso = stringa2 + stringa1;
        System.out.println("Esercizio 2: Concatenazione normale: " + normale);
        System.out.println("Esercizio 2: Concatenazione inversa: " + inverso);
    }

    public static float perimetroRettangolo(float l, float h) {
        return (l*2) + (h*2);
    }

    public static int pariDispari(int n){
        return n % 2;
    }

    public static float perimetroTriangolo(float a, float b, float c) {
        float perimetro = a + b + c;
        float p = perimetro / 2;
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


    public static void main(String[] args){
        String[] array = { "primo", "secondo", "terzo", "quarto", "quinto"};

        System.out.println("Esercizio 1 - 1: " + moltiplica(2, 5));
        System.out.println("Esercizio 1 - 2: " + concatena("pippo", 5));
        System.out.println("Esercizio 1 - 3: " + Arrays.toString(inserisciInArray(array, "pippo")));


        String s1 = input("Inserisci la prima stringa");
        String s2 = input("Inserisci la seconda stringa");
        stringOrder(s1, s2);

        System.out.println("Esercizio 3 - 1: il perimetro è " + perimetroRettangolo(2,4));
        System.out.println("Esercizio 3 - 2: " + pariDispari(5));
        System.out.println("Esercizio 3 - 3: l'area è " + perimetroTriangolo(2,3,4));

    }


}
