package azienda;

public class DipendentePartTime extends Dipendente{

    private int oreLavorative;

    public int getOreLavorative() {
        return oreLavorative;
    }

    public void setOreLavorative(int oreLavorative) {
        this.oreLavorative = oreLavorative;
    }



    public DipendentePartTime(String matricola, double stipendio, Dipartimento dip, int oreLavorative) {
        super(matricola, stipendio, dip);
        this.oreLavorative = oreLavorative;
    }




}
