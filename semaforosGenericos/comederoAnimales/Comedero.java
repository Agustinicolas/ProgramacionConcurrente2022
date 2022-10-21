package semaforosGenericos.comederoAnimales;

import java.util.concurrent.Semaphore;

public class Comedero {

    private Semaphore semCantComederos;
    private String permitido;
    
    public Comedero(int n){
        semCantComederos = new Semaphore(n);
        this.permitido = ""; 

    }

    public void ingresarAComedero(String id){
        if(semCantComederos.availablePermits() == 20){
            permitido = id;
        }
        try{
            semCantComederos.acquire(1);
        }catch(InterruptedException e){}
    }

    public void salirComedero(){
        semCantComederos.release(1);
    }

    
}
