package it.epicode.g3.es3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Ufficiale {
    private Ufficiale superiore;
    private double stipendio;

    public void doCheck(double cifra){
        if(cifra <= this.stipendio) System.out.println("Lo stipendio di " + this.getClass().getSimpleName() + " è maggiore di " + cifra);
        if(superiore != null) {
            this.superiore.doCheck(cifra);
        } else {
            System.out.println("Non ci sono altri ufficiali di grado superiore");
        }
    }
}
