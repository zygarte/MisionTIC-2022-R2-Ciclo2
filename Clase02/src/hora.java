//Programa java que lea tres números enteros H, M, S que contienen hora, minutos y segundos respectivamente, y comprueba si la hora que indican es una hora válida.

import java.util.Scanner;

public class hora {

    
    public static void main(String[] args) {                                                                      
        int H,M,S;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduzca hora: ");
            H =  sc.nextInt();
            System.out.print("Introduzca minutos: ");
            M =  sc.nextInt();
            System.out.print("Introduzca segundos: ");
            S =  sc.nextInt();
        }
        if(H>=0 && H<24 && M>=0 && M<60 && S>=0 && S<60)                                                          
           System.out.println("Hora correcta");
        else
            System.out.println("Hora incorrecta");
    }



    
}
