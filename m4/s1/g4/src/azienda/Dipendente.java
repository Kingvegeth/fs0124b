package azienda;

public abstract class Dipendente implements turni{
    private String matricola;
    private double stipendio;
    private Dipartimento dipartimento;

    public double getStipendio() {
        return stipendio;
    }

    public String getMatricola() {
        return matricola;
    }



    public Dipendente(String matricola, double stipendio, Dipartimento dip){
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dip;
    }



    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }


    public double calculateSalary(){
        return this.getStipendio();
    }


    @Override
    public void checkin() {
        String ruolo = "";
        String inizioTurno = "";
        if (this instanceof DipendenteFullTime){
            ruolo="Dipendente Full Time";
            inizioTurno = "09:00";
        } else if (this instanceof DipendentePartTime) {
            ruolo="Dipendente Part Time";
            inizioTurno = "10:30";
        } else if (this instanceof Dirigente) {
            ruolo="Dirigente";
            inizioTurno = "11:00";
        }
        System.out.println("Il " + ruolo + " con matricola " + this.getMatricola() + " inizia il turno alle ore " + inizioTurno);
    }
}

