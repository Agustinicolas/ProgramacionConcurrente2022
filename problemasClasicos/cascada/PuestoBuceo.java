package problemasClasicos.cascada;

import java.util.concurrent.Semaphore;


public class PuestoBuceo {
    
    private int cantSnorkel;
    private int cantAntiparras;
    private Semaphore semSnorkel;
    private Semaphore semAntiparras;
    private Object depositoSnorkel;
    private Object depositoAntiparras;
    private Semaphore semDepSnorkel;
    private Semaphore semDepAntiparras;

    

    public PuestoBuceo(){
        cantSnorkel = 10;
        cantAntiparras = 7;
        semSnorkel = new Semaphore(0, true);
        semAntiparras = new Semaphore(0);
    }

    public void colocarSnorkel(){
        synchronized(depositoSnorkel){
            
        }
    }
}
