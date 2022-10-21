package semaforosGenericos.comederoAnimales;

import java.util.concurrent.Semaphore;

public class Comedero {

    private Semaphore semCantComederos;
    
    public Comedero(int n){
        semCantComederos = new Semaphore(n);

    }

    public void ingresarAComedero(){
        try{
            semCantComederos.acquire(1);
        }catch(InterruptedException e){}
    }

    public void salirComedero(){
        semCantComederos.release(1);
    }

    
}
