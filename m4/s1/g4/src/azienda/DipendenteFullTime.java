package azienda;

public class DipendenteFullTime extends Dipendente{

    public DipendenteFullTime(String matricola, double stipendio, Dipartimento dip) {
        super(matricola, stipendio, dip);
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary();
    }
}
