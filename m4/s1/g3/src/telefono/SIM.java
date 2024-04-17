package telefono;

public class SIM {
    private int numeroTelefono;
    private int credito;
    private Chiamata[] listaChiamate;

    public SIM(){
        numeroTelefono = 123456789;
        credito = 0;
        listaChiamate = new Chiamata[5];
    }

    public SIM(int numero){
        numeroTelefono = numero;
    }

    public void stampaDatiSIM(){
        System.out.println("Numero di telefono: " + numeroTelefono);
        System.out.println("Credito residuo: " + credito);
        System.out.println("Ultime 5 chiamate: ");
        if (listaChiamate != null) {
            for (int i = 0; i < listaChiamate.length; i++) {
                System.out.println(listaChiamate[i]);
            }
        }
        else{
            System.out.println("Nessuna chiamata effettuata");
        }
    }


}
