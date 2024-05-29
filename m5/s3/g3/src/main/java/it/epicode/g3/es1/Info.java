package it.epicode.g3.es1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Info  {
    private String nome;
    private String cognome;
    private Date dataDiNascita;

}
