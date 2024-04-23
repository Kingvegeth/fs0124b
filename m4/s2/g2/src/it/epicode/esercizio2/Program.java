package it.epicode.esercizio2;

import java.util.ArrayList;
import java.util.Random;

public class Program {

    private static ArrayList<Integer> generateList(int n){

        var lista = new ArrayList<Integer>();

        for (int i = 0; i< n; i++) {
            Random rnd = new Random();
            int num = rnd.nextInt(101);
            lista.add(num);
        }

        return lista;
    }

    private static ArrayList<Integer> listaDoppia(ArrayList<Integer> list){
        var lista = new ArrayList<Integer>();
        lista.addAll(list);
        lista.addAll(list.reversed());
        return lista;
    }

    private static void oddsOrEvens (ArrayList<Integer> list, boolean b){

        int j = b ? 0 : 1;
        String parita = null;
        if (j==0) parita = "pari";
        else parita = "dispari";

        System.out.println("Stampa degli elementi con indice " + parita);
        for (int i = j;i<list.size(); i=i+2){
            System.out.print(list.get(i) + " ,");
        }
    }


    public static void main(String[] args){

        var list = generateList(20);

        System.out.println();
        System.out.println(list);
        System.out.println();
        System.out.println(listaDoppia(list));
        System.out.println();
        oddsOrEvens(list,true);
        System.out.println();
    }


}
