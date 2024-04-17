package ecommerce;

import java.util.ArrayList;

public class Carrello {

    String cliente;
    ArrayList<String> articoli;
    float totale;


    public Carrello(){
        totale = 0;
        this.articoli = new ArrayList<>();
    }

    public void addArticle(Cliente c, Articolo a){
        cliente = c.nome + " " + c.cognome;
        articoli.add(a.descrizione);
        totale += a.prezzo;
        System.out.println("Articolo '" + a.descrizione + "' aggiunto al carrello!");
    }

    public void leggiCarrello(){
        System.out.println("Cliente: "+cliente);
        System.out.println("Articoli nel carrello");
        for (int i =0; i< articoli.size(); i++){
            System.out.println(articoli.get(i));
        }
        System.out.println("Totale: " + totale + "€");
    }


}
