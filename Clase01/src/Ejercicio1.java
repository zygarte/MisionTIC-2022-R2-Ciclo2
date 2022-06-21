public class Ejercicio1 {
    
    public static void main(String[] args) throws Exception {
        var nombre= "William Lozano";

        var resultado = saludo(nombre);

        System.out.println(resultado);
    }

    private static String saludo(String nombre) {
        return "Hola " + nombre +"!";
    }
}
