package tp0;
import java.time.*;

class Alquiler{
    private Cliente cliente;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int amarre;
    private Barco barco;

    public Alquiler(Cliente unCliente, LocalDate fechaInicial, LocalDate fechaFinal, int amarre, Barco unBarco){
        this.cliente = unCliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.amarre = amarre;
        this.barco = unBarco;
    }

    public int calcularValor(){
        //calcula el valor de un alquiler en base a la cantidad de dias del mismo y el tipo de barco. retorna entero
        Period periodo;
        int dias;
        int valorFijo;
        int modulo;
        int valorAlq;

        periodo = Period.between(fechaInicial, fechaFinal);
        dias = periodo.getDays();
        valorFijo = 200;
        modulo = barco.calcularModulo();
        valorAlq = modulo * dias + valorFijo;

        return valorAlq;
    }

    public Alquiler registrarAlquiler(int nroAmarre, Barco unBarco, Cliente unCliente, int cantDias){
        //crea una instancia de Alquiler, calculando fecha inicial y final en base a hoy y cantDias ingresados por parametro
        LocalDate fechaI = LocalDate.now();
        LocalDate fechaF = fechaI.plusDays(cantDias);

        Alquiler alq = new Alquiler(unCliente, fechaI, fechaF, nroAmarre, unBarco);

        return alq;
    }

}

class Barco{
    private String matricula;
    private int eslora;
    private int anioFab;

    public Barco(String matricula, int eslora, int anioFab){
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFab = anioFab;
    }

    public int calcularModulo(){
        int valor = eslora * 10;
        return valor;
    }
}

class Velero extends Barco{
    //subclase de clase Barco
    private int mastiles;

    public Velero(String matricula, int eslora, int anioFab, int mastiles){
        super(matricula, eslora, anioFab);
        this.mastiles = mastiles;
    }

    public int calcularModulo(){
        //metodo polimorfico. Refinamiento
        int valor;

        valor = super.calcularModulo();
        valor = valor + mastiles;

        return valor;
    }
    
}

class Deportivo extends Barco{
    private int cv;

    public Deportivo(String matricula, int eslora, int anioFab, int cv){
        super(matricula, eslora, anioFab);
        this.cv = cv;
    }

    public int calcularModulo(){
        //metodo polimorfico. Refinamiento
        int valor;

        valor = super.calcularModulo();
        valor = valor + cv;

        return valor;
    }

}

class Yate extends Barco{
    private int cv;
    private int camarotes;

    public Yate(String matricula, int eslora, int anioFab, int cv, int camarotes){
        super(matricula, eslora, anioFab);
        this.cv = cv;
        this.camarotes = camarotes;
    }

    public int calcularModulo(){
        //metodo polimorfico. Refinamiento
        int valor;

        valor = super.calcularModulo();
        valor = valor + cv + camarotes;

        return valor;
    }
}

class Cliente{
    private long dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

    public Cliente(long dni, String nombre, String apellido, LocalDate fechaNac){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;

    }
}

public class Ejercicio2 {
    
}