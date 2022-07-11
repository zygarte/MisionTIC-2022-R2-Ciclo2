package Herencia;

public class Persona {

    protected static String nombre;
    protected static char genero;
    protected static int edad;
    protected static String direccion;

    public Persona(){ 
    }
    
    public Persona(String nombre){
        this.nombre = nombre;
    }
    
    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "\nnombre=" + nombre + "\ngenero=" + genero + 
                "\nedad=" + edad + "\ndireccion=" + direccion + '}';
    }
    
    
    
    
    
    
}
