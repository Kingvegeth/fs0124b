package it.epicode.mediaPlayer;

public class Video extends Riproducibile implements ElementiVisualizzabili{

    private int luminosita;


    public Video(String titolo, int durata){

        this.setTitolo(titolo);
        this.setDurata(durata);
        this.setLuminosita(50);
        this.setVolume(50);

    }


    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }



    @Override
    public void play() {

        for (int i=0; i< this.getDurata(); i++){

            System.out.print(this.getTitolo() + " - ");
            for (int j=0; j<this.getVolume(); j++){
                System.out.print("!");
            }
            System.out.print(" - ");
            for (int k=0; k<this.getLuminosita(); k++){
                System.out.print("*");
            }
            System.out.println(".");
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
