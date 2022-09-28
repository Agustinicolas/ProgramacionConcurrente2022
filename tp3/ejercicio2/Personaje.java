package tp3.ejercicio2;

public class Personaje implements Runnable{
    protected int poder;
    protected Vida target;

    public Personaje(int poder, Vida objetivo){
        this.poder = poder;
        this.target = objetivo;
    }

    public void run(){

        synchronized(target){
            System.out.println("Obtener vida");
            int vida = target.getHp();
            System.out.println("Calcular nueva vida");
            vida = vida + poder;
            System.out.println("Modificando vida");
            target.setHp(vida);
        }
    }
}
