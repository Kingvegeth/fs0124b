package telefono;

public class Chiamata {

    private int minuti;
    private int numeroChiamato;

    public Chiamata(){
        minuti = 0;
    }

    public void setMinuti(int minuti){
        this.minuti = minuti;
    }

    public int getMinuti(){
        return minuti;
    }

    public void setNumero(int numero){
        this.numeroChiamato = numero;
    }

    public int getNumero(){
        return numeroChiamato;
    }


}
