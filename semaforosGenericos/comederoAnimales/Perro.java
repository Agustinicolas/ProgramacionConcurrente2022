package semaforosGenericos.comederoAnimales;

public class Perro implements Runnable {
    
    private Comedero comedero;
    private static String ESPECIE = "Perro";

    public Perro(Comedero comedero){
        this.comedero = comedero;
    }

    public void run(){

        //  PERRO INTENTA ENTRAR A COMEDERO

        //  PERRO COME

        //  PERRO SALE COMEDERO
    }
}
