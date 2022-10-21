package problemasClasicos.barberoDormilon;

public class Cliente implements Runnable {

    private int numero;
    private Barberia barberia;

    public Cliente(Barberia barberia, int n){
        this.barberia = barberia;
        this.numero = n;
    }

    public int getNumero(){
        return this.numero;
    }
    @Override
    public void run() {
        barberia.ingreso();
        
        barberia.salir();
    }
    
}
