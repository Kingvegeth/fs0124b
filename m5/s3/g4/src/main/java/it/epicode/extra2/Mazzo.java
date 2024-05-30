package it.epicode.extra2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {

    private List<Carta> carte;

    public Mazzo(){
        carte = new ArrayList<>();
        for (Seme seme : Seme.values()){
            for (int valore = 1; valore <= 13; valore++){
                carte.add(new Carta(valore,seme));
            }
        }
    }

    public void mischia(){
        Collections.shuffle(carte);
    }

    public Carta distribuisci(){
        if (carte.isEmpty()){
            throw new IllegalStateException("Non ci sono più carte nel mazzo");
        }
        return carte.remove(0);
    }


    @Override
    public String toString() {
        return "Mazzo{" +
                "carte=" + carte +
                '}';
    }
}
