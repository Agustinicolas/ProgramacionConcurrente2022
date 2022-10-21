package problemasClasicos.cascada;
import java.util.concurrent.*;

public class Deposito {
    private int cantidad;
    private Semaphore sem;

    public Deposito(int n){
        this.cantidad = n;
        sem = new Semaphore(1);
    }

    private synchronized void actualizar(){
        if(cant > 0){
            
        }
    }
}
