package tp3.ejercicio3;

public class ComputadoraCentral {

    protected int[] asientos;
    protected int reservados;
    protected int capacidad;

    public ComputadoraCentral(int n){
        this.capacidad = n;
        this.asientos = new int[capacidad];
        this.reservados = 0;
        
        for(int i = 0; i < n; i++){
            asientos[i] = 0;
        }
    }

    public int getDisp(int n){
        return asientos[n];
    }

    public String toString(){
        String asientos = "";
        String indices = "";

        for(int i = 0; i < capacidad; i++){
            asientos = asientos + this.getDisp(i)+"\t";
        }

        for(int i = 0; i < capacidad; i++){
            indices = indices + i +"\t";
        }

        return(asientos+"\n"+indices);

    }
    
    public static void main(String[] args){
        String s;
        ComputadoraCentral compuC = new ComputadoraCentral(10);
        s = compuC.toString();
        System.out.println(s);
        
    }
}
