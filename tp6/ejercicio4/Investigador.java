package tp6.ejercicio4;

public class Investigador implements Runnable {
    private Sala sala;
    private int num;

    public Investigador(Sala sala, int n){
        this.sala = sala;
        this.num = n;
    }

    public void run(){
        sala.ingresoInvestigador(num);
        investigacion();
        sala.salidaInvestigador(num);
    }

    public void investigacion(){
        try{
            System.out.println("Investigador "+num+" trabaja en su investigacion");
            Thread.sleep(4000);
        }catch(InterruptedException e){}
    }
}
