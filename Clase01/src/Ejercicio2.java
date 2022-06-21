import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws Exception {
        try (var sc = new Scanner(System.in)) {
            System.out.println("Introduce un numero entero: ");
            var numero = sc.nextInt();

            var digitos = numeroDigitos(numero);
            System.out.println("el numero tiene "+ digitos + " cifras y/o digitos.");
        }

        
    }

    private static Object numeroDigitos(int numero) {

        var cifras = 0;

        while (numero != 0) {
            numero /= 10;
            cifras++;
        }
        return cifras;
    }

    
}
