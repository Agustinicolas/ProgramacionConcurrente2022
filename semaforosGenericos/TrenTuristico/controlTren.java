package semaforosGenericos.TrenTuristico;

import java.util.concurrent.Semaphore;

public class controlTren {
    private int cantPasajeros;
    private Semaphore semAsientos;
    private Semaphore semTickets;

    public controlTren(int n){
        this.cantPasajeros = n;
        semAsientos = new Semaphore(n,true);
        semTickets = new Semaphore(1,true);
    }
    
}
