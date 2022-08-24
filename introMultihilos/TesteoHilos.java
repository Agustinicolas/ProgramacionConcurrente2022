package introMultihilos;

public class TesteoHilos {

    public static void main(String[] args){
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try{
            miHilo.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("En el main");
        
    }
    
}
