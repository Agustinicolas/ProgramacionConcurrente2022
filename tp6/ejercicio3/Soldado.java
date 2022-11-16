package tp6.ejercicio3;
import java.util.Random;
import java.util.Random.*;

public class Soldado implements Runnable{
    
    private Comedor comedor;
    private int numero;

    public Soldado(Comedor comedor, int n){
        this.comedor = comedor;
        this.numero = n;
    }

    public void run(){
        Random rnd = new Random();
        int bebida = rnd.nextInt(2);
        int postre = rnd.nextInt(2);
        comedor.tomarBandeja(bebida, postre, numero);
        almorzar();
        comedor.salir(numero);
    }

    public void almorzar(){
        System.out.println("Soldado "+numero+" comiendo...");
        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){}
    }
}
