package tp6.ejercicio4;

public class Visitante implements Runnable{
    private Sala sala;
    private int num;

    public Visitante(Sala sala, int n){
        this.sala = sala;
        this.num = n;
    }

    public void run(){
        sala.ingresoVisitante(num);
        estudio();
        sala.salidaVisitante(num);
    }

    public void estudio(){
        System.out.println("Visitante "+num+" estudia las estrellas");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}
    }
    
}
