package it.epicode.mediaPlayer;

public class Immagine extends Media implements ElementiVisualizzabili{

    private int luminosita;

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }


    public void show(){

        System.out.print(this.getTitolo() + " - ");
        for (int i = 0; i<this.getLuminosita(); i++){
            System.out.print("*");
        }

    }


    @Override
    public void alzaLuminosita() {
        if(luminosita<100){
            luminosita++;
        } else{
            System.out.println("Luminosità già al massimo!");
        }
    }

    @Override
    public void abbassaLuminosita() {
        if(luminosita>0){
            luminosita--;
        } else{
            System.out.println("Luminosità già al minimo!");
        }
    }
}
