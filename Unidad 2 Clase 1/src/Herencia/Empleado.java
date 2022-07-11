package Herencia;

public class Empleado extends Persona {
    
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    public Empleado(){
        // super();
        //this.idEmpleado = ++Empleado.contadorEmpleado;
    }
    
    //public Empleado(String nombre, double sueldo){
    public Empleado(double sueldo){
        //this();
        this.idEmpleado = ++contadorEmpleado;
        this.sueldo = sueldo;        
    }
    
//    public Empleado(double sueldo, String nombre, char genero, int edad, String direccion) {
//        super(nombre, genero, edad, direccion);
//        this.sueldo = sueldo;
//    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public static int getContadorEmpleado() {
        return contadorEmpleado;
    }

  

    @Override
    public String toString() {
        return super.toString() + "\nidEmpleado=" + idEmpleado +
                "\nsueldo=" + sueldo + ' ';
    }
    
    
    
    
    
    
}
