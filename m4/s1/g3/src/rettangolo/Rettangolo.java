package rettangolo;

public class Rettangolo {

    private double base;
    private double altezza;

    public Rettangolo(){
        base = 0;
        altezza = 0;
    }

    public Rettangolo(double b, double h){
        base = b;
        altezza = h;
    }

    public double area(){
        return base * altezza;
    }

    public double perimetro(){
        return base*2 + altezza*2;
    }


}

