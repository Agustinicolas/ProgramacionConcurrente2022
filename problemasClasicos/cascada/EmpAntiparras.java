package problemasClasicos.cascada;

public class EmpAntiparras {
    private PuestoBuceo puesto;

    public EmpAntiparras(PuestoBuceo puesto){
        this.puesto = puesto;
    }

    public void run(){
        while(true){
            puesto.colocarAntiparras();
        }
    }
}
