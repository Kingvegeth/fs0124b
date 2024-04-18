package azienda;

public class Volontario implements turni{

    private String nome;
    private String cognome;
    private int età;
    private String cv;


    public Volontario(String nome, String cognome, int età, String cv) {
        this.nome = nome;
        this.cognome = cognome;
        this.età = età;
        this.cv = cv;
    }


    @Override
    public void checkin() {
        System.out.println("Il volontario " + this.nome + " " + this.cognome + " inizia il turno alle ore 15:00.");
    }
}
