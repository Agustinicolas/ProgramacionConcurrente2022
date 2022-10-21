package problemasClasicos.barberoDormilon;

public class Barbero implements Runnable {
    
    private Barberia barb;
    private int cortes = 0;

    public Barbero(Barberia barb){
        this.barb = barb;
    }

    public void run(){
        while(cortes < 10){
            barb.clienteListo(); //espera que un cliente ocupe sillon
            System.out.println("CORTANDO BRR BRR");
            barb.corteListo();
            
            cortes++;
        }
        System.out.println("10 cortes realizados, cierra barberia");
    }
}
