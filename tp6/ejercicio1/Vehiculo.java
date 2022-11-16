package tp6.ejercicio1;
import java.util.Random;
import java.util.Random.*;

public class Vehiculo implements Runnable{
    private GestorTrafico gestor;
    private int numero;

    public Vehiculo(int numero, GestorTrafico gestor){
        this.gestor = gestor;
        this.numero = numero;
    }

    public void run(){
        Random rnd = new Random();
        int sentido = rnd.nextInt(2);

        if(sentido == 0){ //auto ingresa por norte
            gestor.entrarCocheDelNorte(numero);
            crucePuente();
            gestor.salirCocheDelSur(numero);
        }else{  //auto ingresa por sur
            gestor.entrarCocheDelSur(numero);
            crucePuente();
            gestor.salirCocheDelNorte(numero);
        }

    }

    public void crucePuente(){
        System.out.println("Vehiculo "+this.numero+" cruza puente...");
        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){}
    }
}
