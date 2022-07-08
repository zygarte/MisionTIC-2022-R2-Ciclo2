import java.util.Scanner;

public class Cuadrado {

    //Método principal de java
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //Declaración de variables
        String colorDelCuadrado;
        double ladoDelCuadrado;

        //Se instancia a la variable "Scanner"
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca el color del cuadrado: ");
        colorDelCuadrado = sc.nextLine();

        System.out.print("Introduzca el lado del cuadrado: ");
        ladoDelCuadrado = sc.nextDouble();

        CuadradoFigura cuadrado1 = new CuadradoFigura(colorDelCuadrado, ladoDelCuadrado);

        System.out.printf("El área del cuadrado %s es: %f", cuadrado1.getColor(), cuadrado1.calcularArea());
        sc.close();
    }
    
    
}


