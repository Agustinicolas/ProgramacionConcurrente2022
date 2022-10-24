package actividadObligatoriaGrupal.buqueAutos;

public class Auto implements Runnable {
    
    private Buque buque;

    public Auto(Buque buque){
        this.buque = buque;
    }

    public void run(){

        //AUTO INTENTA SUBIR AL BUQUE
        buque.ingreso();

        buque.salida();

    }
}
