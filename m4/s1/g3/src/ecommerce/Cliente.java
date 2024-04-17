package ecommerce;

import java.util.Date;

public class Cliente {
    int codice;
    String nome;
    String cognome;
    String email;
    Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public Cliente(int cod, String n, String c, String e){
        codice = cod;
        nome = n;
        cognome = c;
        email = e;
        data = new Date();

    }





}
