package introMultihilos;

public class RunnableEjemplo implements Runnable {

    private String msj;
    
    public RunnableEjemplo(String str){ //constructor de cero
        this.msj = str;
    } 

    public String getMsj(){
        return this.msj;
    }
    
    public void start(){
        this.run();
    }

    public void run(){ //explicitar un metodo run()
        for (int i = 0; i < 10; i++){
            System.out.println(i + " " + this.getMsj());
        }
        System.out.println("Termina Thread " +this.getMsj());
    }

    public static void main(String[] args){
        RunnableEjemplo r1 = new RunnableEjemplo("Maria Jose"); //crear objetos
        RunnableEjemplo r2 = new RunnableEjemplo("Jose Maria");

        Thread t1 = new Thread(r1); //crear hilos y "asignarlos" a los objetos 
        Thread t2 = new Thread(r2);
        t1.start(); //comenzar los hilos
        t2.start();
        System.out.println("Termina thread main");
    }

}
