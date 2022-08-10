package tp0;
import java.time.*;
import java.util.*;

class Persona{
    private int dni;
    private String nombre;
    private LocalDate fechaNac;
    private char sexo;

    public Persona(int dni, String unNombre, LocalDate unaFecha, char unSexo){
        this.dni = dni;
        this.nombre = unNombre;
        this.fechaNac = unaFecha;
        this.sexo = unSexo;
    }
}

class Empleado extends Persona{
    private String legajo;
    private int antiguedad;
    private double salario;

    public Empleado(int dni, String unNombre, LocalDate unaFecha, char unSexo, String unLegajo, int unaAntiguedad){
        super(dni, unNombre, unaFecha, unSexo);
        this.legajo = unLegajo;
        this.antiguedad = unaAntiguedad;
        this.salario = calculoSalario();
    }

    protected double calculoSalario(){
        double salario;
        double salarioBase = 35000;

        salario = salarioBase + ( salarioBase * ( this.antiguedad / 0.05));

        return salario;
    }

    protected boolean verificarAntiguedadDiez(){
        boolean mayor;
        mayor = this.antiguedad > 10;

        return mayor;
    }
}


class Administrativo extends Empleado{
    private String categoria;

    public Administrativo(int dni, String unNombre, LocalDate unaFecha, char unSexo, String unLegajo, int unaAntiguedad, String categoria){
        super(dni, unNombre, unaFecha, unSexo, unLegajo, unaAntiguedad);
        this.categoria = categoria;
    }

    protected double calculoSalario(){
        double salario;
        double plusCategoria = 0;
        String cat = this.categoria.toUpperCase();

        if (cat.equals("A")){
            plusCategoria = 15000;
        }else if(cat.equals("B")){
            plusCategoria = 20000;
        }else if(cat.equals("C")){
            plusCategoria = 25000;
        }

        salario = super.calculoSalario() + plusCategoria;

        return salario;
    }
}


class Tecnico extends Empleado{
    private String titulo;
    private int anioTitulo;

    public Tecnico(int dni, String unNombre, LocalDate unaFecha, char unSexo, String unLegajo, int unaAntiguedad, String unTitulo, int unAnio){
        super(dni, unNombre, unaFecha, unSexo, unLegajo, unaAntiguedad);
        this.titulo = unTitulo;
        this.anioTitulo = unAnio;
    }

    protected double calculoSalario(){
        double salario;
        double plusTitulo = 0;
        String tit = this.titulo.toLowerCase();

        if(tit.equals("terciario")){
            plusTitulo = 20000;
        }else if(tit.equals("grado")){
            plusTitulo = 25000;
        }else if(tit.equals("posgrado")){
            plusTitulo = 35000;
        }

        salario = super.calculoSalario() + plusTitulo;
        return salario;
    }

}

class Empresa{
    private ArrayList<Empleado> colEmpleados;

    public Empresa(){
        this.colEmpleados = new ArrayList<Empleado>();
    }

    public void agregarEmpleado(Empleado unEmpleado){
        colEmpleados.add(unEmpleado);
    }

    public ArrayList<Empleado> mayorADiez(){
        ArrayList<Empleado> coleccion = new ArrayList<Empleado>;
        int indice = 0;
        Empleado elem;
        int tamanio = this.colEmpleados.size();
        boolean mayor;

        for(indice = 0; indice < tamanio; indice++){
            elem = this.colEmpleados.get(indice);
            
            mayor = elem.verificarAntiguedadDiez();
            if(mayor){
                coleccion.add(elem);
            }
        }

        return coleccion;


    }
    
}

public class Ejercicio3 {
    
}
