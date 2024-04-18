package rettangolo;

public class Main {

    public static void stampaRettangolo(Rettangolo rettangolo){
        System.out.println("Area: " + rettangolo.area() + " Perimetro: " + rettangolo.perimetro());
    }

    public static void main(String[] args) {

        Rettangolo rettangolo1 = new Rettangolo(2,4);
        stampaRettangolo(rettangolo1);


    }


}