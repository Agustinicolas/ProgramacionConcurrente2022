package problemasClasicos.cascada;

public class EmpSnorkel {
    
    private PuestoBuceo puesto;

    public EmpSnorkel(PuestoBuceo puesto){
        this.puesto = puesto;
    }

    public void run(){
        while(true){
            puesto.colocarSnorkel();
        }
    }

}
