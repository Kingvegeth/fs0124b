package ecommerce;

public class Articolo {

    int codice;
    String descrizione;
    float prezzo;
    int pezziDisponibili;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getPezziDisponibili() {
        return pezziDisponibili;
    }

    public void setPezziDisponibili(int pezziDisponibili) {
        this.pezziDisponibili = pezziDisponibili;
    }




    public Articolo(){
        codice = 0;
        descrizione = "";
        prezzo = 0;
        pezziDisponibili = 0;
    }

    public Articolo(int cod, String desc, float pr, int disp){
        codice = cod;
        descrizione = desc;
        prezzo = pr;
        pezziDisponibili = disp;
    }


}
