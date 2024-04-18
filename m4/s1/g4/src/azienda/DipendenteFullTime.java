package azienda;

public class DipendenteFullTime extends Dipendente implements turni{

    public DipendenteFullTime(String matricola, double stipendio, Dipartimento dip) {
        super(matricola, stipendio, dip);
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary();
    }

    @Override
    public void checkin() {
        String ruolo = "dipendente full time";
        String inizioTurno ="09:00";
        System.out.println("Il " + ruolo + " con matricola " + this.getMatricola() + " inizia il turno alle ore " + inizioTurno + ".");
    }
}
