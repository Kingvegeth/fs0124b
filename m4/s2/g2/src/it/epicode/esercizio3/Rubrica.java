package it.epicode.esercizio3;


public class Rubrica {

    private String telefono;
    private String contatto;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContatto() {
        return contatto;
    }

    public void setContatto(String contatto) {
        this.contatto = contatto;
    }

    public Rubrica(String contatto, String telefono) {
        this.telefono = telefono;
        this.contatto = contatto;
    }


    @Override
    public boolean equals(Object obj){
        return obj instanceof Rubrica && obj.hashCode() == this.hashCode();
    }




    @Override
    public String toString() {
        return String.format("contatto= %s, telefono= %s", contatto,
                telefono);
    }

}
