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

    public static void main(String[] args){
        int n = inputInteger("Inserisci un intero");
        double d = inputDouble("Inserisci un numero");
        String s = input("Inserisci un testo qualsiasi");
        System.out.println(n);
        System.out.println(d);
        System.out.println(s);
    }
}
