package semaforosGenericos.pollosHermanosII;
import java.util.Random;

public class Empleado implements Runnable {

    private EspacioDeComidas espacio;
    private int numero;

    public Empleado(EspacioDeComidas espacio, int n){
        this.espacio = espacio;
        this.numero = n;
    }

    public void run(){
        espacio.ingresarEspacio();
        Random ran = new Random();
        int opcion = ran.nextInt(2);
        switch(opcion){
            case 0:
                System.out.println("Empleado "+numero+" solo ordena bebida:");
                this.beber();
                break;
            case 1:
                System.out.println("Empleado "+numero+" ordena comida y bebida:");
                this.beber();
                this.comer();
                break;
            case 2:
                System.out.println("Empleado "+numero+" solo ordena comida:");
                this.comer();
                break;
        }
        

        espacio.salirEspacio();
        System.out.println("Empleado "+numero+" se retira del espacio de comidas.");
        

    }

    private void beber(){
        espacio.llamarMozo();
        espacio.pedirBebida();
        System.out.println("Empleado "+numero+" pide bebida");
        espacio.esperaBebida();
        System.out.println("Empleado "+numero+" toma bebida");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }
    }

    private void comer(){
        espacio.llamarCocinero();
        espacio.pedirComida();
        System.out.println("Empleado "+numero+" pide comida");
        espacio.esperarComida();
        System.out.println("Empleado "+numero+" toma comida");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }
    }
    
}
