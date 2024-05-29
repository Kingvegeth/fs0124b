package it.epicode.g3.es1;

import lombok.ToString;

@ToString
public class UserData {
    private String nomeCompleto;
    private int eta;

    public void setData(DataSource ds){
        nomeCompleto = ds.getNomeCompleto();
        eta = ds.getEta();
    }
}
