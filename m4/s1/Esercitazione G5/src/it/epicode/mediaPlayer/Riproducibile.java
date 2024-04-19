package it.epicode.mediaPlayer;

public abstract class Riproducibile extends Media implements ElementiRiproducibili{

    private int durata;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }



    @Override
    public void play() {

    }

    @Override
    public void alzaVolume() {

    }

    @Override
    public void abbassaVolume() {

    }

}
