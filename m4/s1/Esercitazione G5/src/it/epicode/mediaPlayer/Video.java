package it.epicode.mediaPlayer;

import it.epicode.mediaPlayer.Interfacce.ElementiVisualizzabili;

public class Video extends Riproducibile implements ElementiVisualizzabili {

    private int luminosita = 5;


    public Video(String titolo, int durata){ // costruttore del video
        this.setTitolo(titolo);
        this.setDurata(durata);

    }


    public int getLuminosita() {
        return luminosita;
    }


    @Override
    public void play() {


        //questa for genera una riga per ogni valore nella durata dell'elemento
        for (int i=0; i< this.getDurata(); i++){

            System.out.print(this.getTitolo() + " - ");
            for (int j=0; j<this.getVolume(); j++){
                System.out.print("!"); //genera un numero di ! pari al valore del volume
            }
            System.out.print(" - ");
            for (int k=0; k<this.getLuminosita(); k++){
                System.out.print("*"); //genera un numero di * pari valore del luminosità
            }
            System.out.println(".");
        }

    }

    @Override
    public void alzaLuminosita() {  //questo metodo aumenta la luminosità, ma non se è già al massimo
        if(luminosita<10){
            luminosita++;
        } else{
            System.out.println("Luminosità già al massimo!");
        }
    }

    @Override
    public void abbassaLuminosita() { //questo metodo riduce la luminosità, ma non se è già al minimo
        if(luminosita>0){
            luminosita--;
        } else{
            System.out.println("Luminosità già al minimo!");
        }
    }


}
