package ecommerce;

public class Program {

    public static void main(String[] args) {

        Cliente marioRossi = new Cliente(1,"Mario","Rossi","mario@rossi.it");
        Articolo pizzaDiavola = new Articolo(1,"Pizza Diavola",5.0f, 15);
        Articolo playstation5 = new Articolo(2,"Playstation 5", 499.95f,5);


        Carrello carrello = new Carrello();

        carrello.addArticle(marioRossi,pizzaDiavola);
        carrello.addArticle(marioRossi,playstation5);

        carrello.leggiCarrello();


    }

}
