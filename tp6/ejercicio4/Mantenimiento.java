package tp6.ejercicio4;

public class Mantenimiento implements Runnable {
    private Sala sala;
    private int num;

    public Mantenimiento(Sala sala, int n){
        this.sala = sala;
        this.num = n;
    }

    public void run(){
        sala.ingresoMantenimiento(num);
        trabajoMantenimiento();
        sala.salidaMantenimiento(num);
    }

    public void trabajoMantenimiento(){
        try{
            System.out.println("Trabajador "+num+" realiza trabajo de mantenimiento");
            Thread.sleep(3500);
        }catch(InterruptedException e){}
    }
}
