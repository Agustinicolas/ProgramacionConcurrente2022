package problemasClasicos.barberoDormilon;

import java.util.concurrent.Semaphore;

public class Barberia {
    
    private Semaphore sillon = new Semaphore(1, true);
    private Semaphore clienteListo = new Semaphore(0);
    private Semaphore corteFinalizado = new Semaphore(0);

    public void clienteListo(){
        try{
            clienteListo.acquire();
        }catch(InterruptedException e){

        }
        System.out.println("BARBERO \t CLIENTELISTO 1 -- 0");

    }

    public void corteListo(){
        corteFinalizado.release();
        System.out.println("BARBERO \t CORTEFINALIZADO 0 -- 1");
    }

    public void ingreso(){
        try{
            sillon.acquire();
        }catch(InterruptedException e){

        }
        System.out.println("CLIENTE\t SILLON 1 -- 0");

        clienteListo.release();
        System.out.println("CLIENTE\t CLIENTELISTO 0 -- 1");

        
    }

    public void salir(){
        try{
            corteFinalizado.acquire();
        }catch(InterruptedException e){

        }
        System.out.println("CLIENTE\t CORTEFINALIZADO 1 -- 0");        
        sillon.release();
        System.out.println("CLIENTE\t SILLON 0 -- 1");
        
    }

    public static void main(String[] args){
        Barberia Local = new Barberia();
        Barbero barbero1 = new Barbero(Local);
        Thread[] arreglo = new Thread[10];

        Thread barb1 = new Thread(barbero1);
        barb1.start();
        for(int i = 0; i<10 ; i++){
            arreglo[i] = new Thread(new Cliente(Local, i+1));
        }
        for(int i = 0; i<10 ; i++){
            arreglo[i].start();
        }
    }

    

    

    
}
