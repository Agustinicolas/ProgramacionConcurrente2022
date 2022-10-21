package problemasClasicos.cascada;

public class Visitante extends Thread{

    private PuestoBuceo puesto;

    public Visitante(PuestoBuceo puesto){
        this.puesto = puesto; 
    }
    
    public void run(){
        puesto.ObtenerSnorkel();

        puesto.obtenerAntiparras();

        this.bucear();

        puesto.devolverAntiparras();

        puesto.devolverSnorkel();
    }

    private void bucear(){
        try{
            sleep(5000);
        }catch(InterruptedException e){
            
        }
    }
}
