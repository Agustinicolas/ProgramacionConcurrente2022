package tp6.ejercicio1;

public class GestorTrafico {

    //OBJETO MONITOR, ATRIBUTOS PRIVADOS Y METODOS SINCRONIZADOS
    
    private int colaNorte;
    private int colaSur;
    private boolean sentidoNorte;

    public GestorTrafico(){
        this.colaNorte = 0;
        this.colaSur = 0;
        sentidoNorte = false;
    }

    public synchronized void entrarCocheDelNorte(int n){
        colaNorte++;
        System.out.println("Coche "+n+" en fila norte");
        
    }

    public synchronized void salirCocheDelNorte(int n){
        
        System.out.println("Coche "+n+" sale por el norte del puente");
    }

    public synchronized void entrarCocheDelSur(int n){
        colaSur++;
        System.out.println("Coche "+n+" en fila sur");

    }

    public synchronized void salirCocheDelSur(int n){

        System.out.println("Coche "+n+" sale por el sur del puente");

    }

    public synchronized void comprobarSentido(){

    }
}
