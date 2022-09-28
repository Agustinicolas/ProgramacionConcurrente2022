package tp3.ejercicio2;


public class Vida {
    int hp;

    public Vida(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return this.hp;
    }

    public void accion(int n){
        this.hp = this.hp + n;
    }

    public void setHp(int n){
        this.hp = n;
    }

    public static void main(String[] args){
        Vida vidaActual = new Vida(10);
        Personaje orco = new Personaje(-3, vidaActual);
        Personaje curandero = new Personaje(3, vidaActual);
        Thread tOrco = new Thread(orco);
        Thread tCurandero = new Thread(curandero);
        System.out.println("Vida actual: "+vidaActual.getHp());

        tOrco.start();
        tCurandero.start();
        try{
            tOrco.join();
        }catch(InterruptedException e){

        }
        try{
            tCurandero.join();
        }catch(InterruptedException e){
            
        }

        
        System.out.println("Vida actual: "+vidaActual.getHp());
        
    }
}
