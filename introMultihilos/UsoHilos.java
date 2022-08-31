package introMultihilos;

class unHilo extends Thread{
    String nombreHilo;

    unHilo(String nombre){
        super();
        this.setName(nombre);
    }

    //Punto de entrada del hilo
    //los hilos comienzan a ejecutarse aqui
    public void run(){
        System.out.println("Comenzando "+nombreHilo);
        try{
            for(int contar = 0 ; contar < 10 ; contar++){
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }catch(InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido");
        }
        System.out.println("Terminado "+nombreHilo);
    }
}

public class UsoHilos {
    public static void main(String[] args){
        System.out.println("Hilo principal iniciando.");

        //Primero, construye un objeto unHilo
        new unHilo("#1").start();

        //Luego, construye un hilo de ese objeto
        //Thread nuevoHilo = new Thread(mh);

        //Finalmente, comienza la ejecucion del hilo
        

        for(int i = 0; i<50; i++){  
            System.out.println(" .");
        }try{
            Thread.sleep(100);
        }catch(InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
