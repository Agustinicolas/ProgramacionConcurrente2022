package tp6.ejercicio3;
import utiles.TecladoIn;

import java.util.concurrent.Semaphore;


public class Comedor {
    private Semaphore semMostradorAlmuerzo;
    private Semaphore semAbridores;
    private Semaphore semMostradorPostre;
    private Semaphore mutexCocina;

    public Comedor(int mostAlmuerzo, int abridores, int mostPostre){
        this.semMostradorAlmuerzo = new Semaphore(mostAlmuerzo,true);
        this.semAbridores = new Semaphore(abridores, true);
        this.semMostradorPostre = new Semaphore(mostPostre, true);
        this.mutexCocina = new Semaphore(1,true);        
    }

    public void tomarBandeja(int bebida, int postre, int num){
        //bebida = 0 agua. bebida = 1 gaseosa
        //come postre si parametro postre es 1

        try{
            semMostradorAlmuerzo.acquire(1);
            System.out.println("Soldado "+num+" agarra bandeja");
            Thread.sleep(500);
        }catch(InterruptedException e){}
        semMostradorAlmuerzo.release(1);

        if(bebida == 1){
            try{
                semAbridores.acquire(1);
                System.out.println("Soldado "+num+" agarro abridor para gaseosa");
                Thread.sleep(400);
                semAbridores.release(1);
            }catch(InterruptedException e){}
        }

        if(postre == 1){
            try{
                semMostradorPostre.acquire(1);
                System.out.println("Soldado "+num+" agarrando postre");
                Thread.sleep(350);
            }catch(InterruptedException e){}
            semMostradorPostre.release(1);
        }
    }

    public void salir(int num){
        try{
            mutexCocina.acquire();
            System.out.println("Soldado "+num+" dejando bandeja en cocina");
            Thread.sleep(300);
        }catch(InterruptedException e){}
        mutexCocina.release();
        System.out.println("Soldado "+num+" se retira de la cocina");
    }

    public static void main(String[] args){
        int cant;
        
        System.out.println("Ingresar cantidad de soldados: ");
        cant = TecladoIn.readLineInt();
        System.out.println("Ingrese cantidad de mostradores de Almuerzo");
        int mostAlmuerzo = TecladoIn.readLineInt();
        System.out.println("Ingrese cantidad abridores: ");
        int abridores = TecladoIn.readLineInt();
        System.out.println("Ingrese cantidad de mostradores de postre: ");
        int mostPostre = TecladoIn.readLineInt();
        Comedor comedor = new Comedor(mostAlmuerzo, abridores, mostPostre);
        Soldado[] arrSoldados = new Soldado[cant];
        Thread[] arrHilos = new Thread[cant];

        for(int i = 0; i <cant; i++){
            arrSoldados[i] = new Soldado(comedor, i);
            arrHilos[i] = new Thread(arrSoldados[i]);
            arrHilos[i].start();
        }
    }
}

