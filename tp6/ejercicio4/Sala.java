package tp6.ejercicio4;

import java.util.concurrent.locks.*;

public class Sala {
    private ReentrantLock lock;
    private final int capacidadMaxima;
    private final int capacidadReducida;
    private int capacidadActual;
    private int cantidadActual;
    private Condition pasanVisitantes;
    private Condition pasanInvestigadores;
    private Condition pasaMantenimiento;
    private int cantVisitantes;
    private int cantInvestigadores;
    private int cantMantenimiento;

    public Sala(){
        this.lock = new ReentrantLock(true);
        this.capacidadMaxima = 50;
        this.capacidadReducida = 30;
        this.capacidadActual = capacidadMaxima;
        this.cantidadActual = 0;
        this.pasanVisitantes = lock.newCondition();
        this.pasanInvestigadores = lock.newCondition();
        this.pasaMantenimiento = lock.newCondition();
        this.cantVisitantes = 0;
        this.cantInvestigadores = 0;
        this.cantMantenimiento = 0;
    }


    public void ingresoVisitante(int n, boolean especial){
        lock.lock();
        try{
            while((cantInvestigadores != 0 || cantMantenimiento != 0) && cantidadActual >= capacidadActual){
                System.out.println("Visitante "+n+" en fila de espera!");
                pasanVisitantes.await();
            }
            System.out.println("Visitante "+n+" ingresa!");
            cantidadActual++;
            cantVisitantes++;
            if(especial){
                capacidadActual = capacidadReducida;
            }

        }catch(InterruptedException e){}
        finally{
            lock.unlock();
        }
    }


    public void salidaVisitante(int n, boolean especial){
        lock.lock();
        try{
            System.out.println("Visitante "+n+" sale del observatorio");
            cantidadActual--;
            cantVisitantes--;
            if(especial){
                capacidadActual = capacidadMaxima;
            }
            if(cantVisitantes == 0){
                pasaMantenimiento.signal();
                pasanInvestigadores.signal();
            }else{
                pasanVisitantes.signal();
            }
        }catch(Exception e){}
        finally{
            lock.unlock();
        }
    }


    public void ingresoInvestigador(int n){

    }
}
