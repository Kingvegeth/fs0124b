package it.epicode.mediaPlayer;

import it.epicode.mediaPlayer.Interfacce.ElementiVisualizzabili;

public class Immagine extends Media implements ElementiVisualizzabili {

    private int luminosita =5;  //la luminosità ha un valore di default pari a 5

    public Immagine(String titolo){ //costruttore dell'immagine
        this.setTitolo(titolo);
    }


    public int getLuminosita() {
        return luminosita;
    }


    public void show(){ //metodo che apre l'immagine.

        System.out.print(this.getTitolo() + " - ");
        for (int i = 0; i<this.getLuminosita(); i++){
            System.out.print("*"); //mostra un numero di * pari al valore di luminosità
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
