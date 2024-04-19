package it.epicode.mediaPlayer;

public class Audio extends Riproducibile{


    public Audio(String titolo, int durata){ //costruttore degli elementi audio
        this.setTitolo(titolo);
        this.setDurata(durata);

    }


    //Metodo play degli elementi audio
    public void play() {

        //questa for genera una riga per ogni valore nella durata dell'elemento
        for (int i=0; i< this.getDurata(); i++){

            System.out.print(this.getTitolo() + " - ");
            for (int j=0; j<this.getVolume(); j++){
                System.out.print("!");
            }
            System.out.println(".");
        }

    }

}