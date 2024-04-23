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

        int j = b ? 1 : 0;

        for (int i = j;i<list.size(); i=i+2){
            System.out.print(list.get(i) + " ,");
        }
    }


    public static void main(String[] args){

        var list = generateList(20);

        System.out.println(list);
        System.out.println(listaDoppia(list));
        oddsOrEvens(list,true);
        //oddsOrEvens(list,false);
    }


}
