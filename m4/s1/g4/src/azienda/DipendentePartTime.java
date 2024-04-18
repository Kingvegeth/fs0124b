package azienda;

public class DipendentePartTime extends Dipendente implements turni{

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


    @Override
    public void checkin() {
        String ruolo = "dipendente part time";
        String inizioTurno ="10:30";
        System.out.println("Il " + ruolo + " con matricola " + this.getMatricola() + " inizia il turno alle ore " + inizioTurno + ".");
    }
}
