package azienda;

public class Dirigente extends Dipendente implements turni{
    public Dirigente(String matricola, double stipendio, Dipartimento dip) {
        super(matricola, stipendio, dip);
    }

    @Override
    public void checkin() {
        String ruolo = "dirigente";
        String inizioTurno ="11:00";
        System.out.println("Il " + ruolo + " con matricola " + this.getMatricola() + " inizia il turno alle ore " + inizioTurno + ".");
    }
}
