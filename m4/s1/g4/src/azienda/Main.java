package azienda;

public class Main {
    public static void main(String[] args) {

        DipendenteFullTime antonioSchipani = new DipendenteFullTime("schip001",3500.00,Dipartimento.AMMINISTRAZIONE);
        DipendenteFullTime simoneNardo = new DipendenteFullTime("nard007",3501.00,Dipartimento.PRODUZIONE);
        DipendentePartTime simoneIengo = new DipendentePartTime("ieng012",20.55, Dipartimento.VENDITE, 80 );

        Volontario remo = new Volontario("Remo","CocaPedretti",27, "Fortnite");

        Dipendente[] dipendenti = {antonioSchipani,simoneNardo,simoneIengo};
        turni[] tuttiILavoratori = {antonioSchipani, simoneNardo, simoneIengo, remo};

        double stipendioTotale = 0;

            for (int i = 0; i < dipendenti.length; i++) {
                stipendioTotale += dipendenti[i].calculateSalary();
            }


        for (int i=0; i<dipendenti.length; i++){
            System.out.println("Lo stipendio con matricola" + dipendenti[i].getMatricola() + "è di " + dipendenti[i].calculateSalary() + "€");
        }
        System.out.println("Il costo totale per gli stipendi è di " + stipendioTotale + "€");

        for (int i=0; i< tuttiILavoratori.length; i++){
            tuttiILavoratori[i].checkin();
        }

    }
}