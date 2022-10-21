package semaforosGenericos.pollosHermanosII;

public class Cocinero implements Runnable{
    private EspacioDeComidas espacio;

    public Cocinero(EspacioDeComidas espacio){
        this.espacio = espacio;
    }

    public void run(){
        while(true){
            System.out.println("Cocinero libre, ordenando cocina y probando recetas...");
            espacio.esperaPedidoComida();
            System.out.println("Preparando comida . . .");
            try{
                Thread.sleep(2500);
            }catch(InterruptedException e){}
            System.out.println("Sirviendo comida");
            espacio.comidaLista();
            espacio.comidaServida();
            
        }
    }
}
