package it.epicode.g3.es1;

import java.time.LocalDate;
import java.time.ZoneId;

public class Adapter implements DataSource{
    private Info info;
    public Adapter(Info info){
        this.info = info;
    }
    @Override
    public String getNomeCompleto() {
        return this.info.getNome() + " " + this.info.getCognome();
    }

    @Override
    public int getEta() {
        LocalDate localDate = this.info.getDataDiNascita().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return LocalDate.now().getYear() - localDate.getYear();
    }
}
