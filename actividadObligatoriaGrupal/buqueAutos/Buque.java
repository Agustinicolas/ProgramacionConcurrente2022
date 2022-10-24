package actividadObligatoriaGrupal.buqueAutos;


public class Buque {
    
    //  OBJETO MONITOR. ATRIBUTOS PRIVADOS Y METODOS SINCRONIZADOS

    private int capacidad;
    private int cantidadActual;
    boolean listoIngreso;
    boolean listoSalida;

    public Buque(int n){
        this.capacidad = n;
        this.cantidadActual = 0;
        listoIngreso = true;
        listoSalida = false;
        
    }

    public synchronized void ingreso(){
        try{
            while(!listoIngreso || cantidadActual == capacidad){
                System.out.println("Buque lleno, auto debe esperar");
                this.wait();
            }
        }catch(InterruptedException e){System.out.println("XXXXXXXXXXXXXXXXXXXX");}
        System.out.println("Auto ingresa a buque");
        cantidadActual++;
        verificarCantidad();
        try{
            while(listoSalida == false)
                this.wait();
        }catch(InterruptedException e){}
        notify();
                
    }

    private synchronized void verificarCantidad(){
        if (cantidadActual == capacidad){
            listoIngreso = false;
            cruzarRio();
        }
        if(cantidadActual == 0){
            listoSalida = false;
            System.out.println("Buque volviendo . . .");
            System.out.println("Buque listo");
            listoIngreso = true;
        }
    }

    private synchronized void cruzarRio(){
        System.out.println("Buque lleno, cruzando rio . . .");
        System.out.println(". . .");
        System.out.println(". . .");
        System.out.println("Buque cruzo rio, descargando autos . . .");
        listoSalida = true;
        notify();
    }

    public synchronized void salida(){
        System.out.println("Auto saliendo de buque");
        cantidadActual--;
        verificarCantidad();
        notify();
    }

    public static void main(String[] args){

        Buque buque = new Buque(10);
        Auto[] arrAutos = new Auto[25];
        Thread[] arrHilos = new Thread[25];

        for (int i = 0; i < 25; i++){
            arrAutos[i] = new Auto(buque);
            arrHilos[i] = new Thread(arrAutos[i]);
            arrHilos[i].start();
        }
    }


}
