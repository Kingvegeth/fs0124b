package it.epicode.extra2;

public class Carta {

    private final int valore;
    private final Seme seme;

    public Carta(int valore, Seme seme) {
        this.valore = valore;
        this.seme = seme;
    }

    public int getValore() {
        return valore;
    }

    public Seme getSeme() {
        return seme;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "valore=" + valore +
                ", seme=" + seme +
                '}';
    }
}
