package semaforosGenericos.pollosHermanosII;

public class Mozo implements Runnable {
    private EspacioDeComidas espacio;

    public Mozo(EspacioDeComidas espacio){
        this.espacio = espacio;
    }

    public void run(){
        while(true){
            System.out.println("Mozo libre, realizando hobby mientras espera pedido");
            espacio.esperaPedidoBebida();
            System.out.println("Preparando bebida . . .");
            try{
                Thread.sleep(1500);
            }catch(InterruptedException e){}
            System.out.println("Sirviendo bebida");
            espacio.bebidaLista();
            espacio.bebidaServida();
            
        }
    }
}
