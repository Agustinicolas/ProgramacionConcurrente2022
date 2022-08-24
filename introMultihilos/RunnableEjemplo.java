package introMultihilos;

public class RunnableEjemplo implements Runnable {

    private String msj;
    
    public RunnableEjemplo(String str){ //constructor de cero
        this.msj = str;
    } 

    public String getMsj(){
        return this.msj;
    }
    
    public void run(){ //explicitar un metodo run()
        for (int i = 0; i < 10; i++){
            System.out.println(i + " " + this.getMsj());
        }
        System.out.println("Termina Thread " +this.getMsj());
    }

    public static void main(String[] args){
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }

}
