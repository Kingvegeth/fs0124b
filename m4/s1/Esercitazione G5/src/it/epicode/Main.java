package it.epicode;

import it.epicode.mediaPlayer.Immagine;
import it.epicode.mediaPlayer.Video;
import it.epicode.mediaPlayer.Audio;

public class Main {
    public static void main(String[] args) {
        Video rickroll = new Video("Rick Roll", 5); //creo un video di prova
        Audio fredAsmr = new Audio("Fred ASMR",10); //creo un audio di prova
        Immagine mikePirata = new Immagine("Mike vestito da pirata"); //creo un'immagine di prova


        //testo il video. prima lo riproduco con luminosità e volume di default
        //poi modifico volume e luminosità e provo a riprodurlo di nuovo
        rickroll.play();
        rickroll.abbassaLuminosita();
        rickroll.alzaVolume();
        rickroll.play();

        //test di riproduzione con l'audio
        fredAsmr.play();
        fredAsmr.alzaVolume();
        fredAsmr.play();

        //test di apertura dell'immagine
        mikePirata.alzaLuminosita();
        mikePirata.show();


    }
}