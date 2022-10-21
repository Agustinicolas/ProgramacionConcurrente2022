package semaforosGenericos.pollosHermanosII;
import java.util.concurrent.*;

public class EspacioDeComidas {
    
    private Semaphore semEspacio = new Semaphore(2,true);
    private Semaphore semMozo = new Semaphore(1);
    private Semaphore semPedidoBebida = new Semaphore(0);
    private Semaphore semBebidaLista = new Semaphore(0);
    private Semaphore semCocinero = new Semaphore(1);
    private Semaphore semPedidoComida = new Semaphore(0);
    private Semaphore semComidaLista = new Semaphore(1);

    public void ingresarEspacio(){
        try{
            semEspacio.acquire(1);
        }catch(InterruptedException e){

        }
        System.out.println("Empleado ingresa a espacio de comidas y se sienta.");
    }

    public void salirEspacio(){
        semEspacio.release(1);
        
    }

    public void llamarMozo(){
        try{
            semMozo.acquire();
        }catch(InterruptedException e){

        }
    }

    public void llamarCocinero(){
        try{
            semCocinero.acquire();
        }catch(InterruptedException e){}
    }

    public void pedirBebida(){
        semPedidoBebida.release();
    }

    public void pedirComida(){
        semPedidoComida.release();
    }

    public void bebidaLista(){
        semBebidaLista.release();
    }

    public void comidaLista(){
        semComidaLista.release();
    }

    public void esperaPedidoBebida(){
        try{
            semPedidoBebida.acquire();
        }catch(InterruptedException e){

        }
    }

    public void esperaPedidoComida(){
        try{
            semPedidoComida.acquire();
        }catch(InterruptedException e){}
    }

    public void esperaBebida(){
        try{
            semBebidaLista.acquire();
        }catch(InterruptedException e){}
    }

    public void esperarComida(){
        try{
            semComidaLista.acquire();
        }catch(InterruptedException e){}
    }

    public void bebidaServida(){
        semMozo.release(1);
    }

    public void comidaServida(){
        semCocinero.release(1);
    }
    public static void main(String[] args){
        EspacioDeComidas pollosHermanos = new EspacioDeComidas();
        Mozo mozo = new Mozo(pollosHermanos);
        Cocinero cocinero = new Cocinero(pollosHermanos);
        Empleado[] arrEmpleados = new Empleado[5];
        Thread[] arrHilos = new Thread[5];
        Thread hiloMozo = new Thread(mozo);
        Thread hiloCocinero = new Thread(cocinero);

        hiloMozo.start();
        hiloCocinero.start();
        
        for(int i = 0; i < 5 ; i++){
            arrEmpleados[i] = new Empleado(pollosHermanos,i+1);
            arrHilos[i] = new Thread(arrEmpleados[i]);
            arrHilos[i].start();
        }
    }

}
