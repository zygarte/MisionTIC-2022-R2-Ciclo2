package Herencia;

import java.util.Date;
import java.util.Scanner;

public class PruebaHerencia {

    public static void main(String[] args) {

        // Empleado empl1 = new Empleado(3500, "Luis", 'm', 32, "Puerta del Angel 31");
        // System.out.println("empl1 = " + empl1);
        // Empleado empl1 = new Empleado("Pepe", 22000.0);
        // System.out.println("empl1 = " + empl1);

        // Dinamica
        Scanner sc = new Scanner(System.in);
        System.out.println("cuantos clientes ? ");
        int nC = sc.nextInt();
        Cliente[] cliente = new Cliente[nC];
        sc.nextLine();

        for (int i = 0; i < nC; i++) {
            System.out.println("nombre del cliente " + (i + 1) + " : ");
            String nombre = sc.nextLine();
            System.out.println("El cliente " + nombre + " es un Vip? (true or false)");
            boolean vip = sc.nextBoolean();
            Date fecha = new Date();

            cliente[i] = new Cliente(fecha, vip);
            sc.nextLine();

        }

        // mostrar clientes
        for (int i = 0; i < nC; i++) {
            System.out.println(cliente[i].toString());
        }

        System.out.println("            Seccion empleados           ");
        System.out.println("Cuantos empleados           ");
        int nE = sc.nextInt();
        sc.nextLine();
        Empleado[] empleado = new Empleado[nE];

        for (int i = 0; i < empleado.length; i++) {
            System.out.println("nombre del empleado " + (i + 1) + " : ");
            String nombreE = sc.nextLine();
            System.out.println("genero (f/m/o) " + (i + 1) + " : ");
            char genero = sc.next().charAt(0);
            System.out.println("edad " + (i + 1) + " : ");
            int edad = sc.nextInt();
            sc.nextLine();
            System.out.println("direccion de residencia " + (i + 1) + " : ");
            String direccion = sc.nextLine();
            System.out.println("sueldo base " + (i + 1) + " : ");
            Double sueldo = sc.nextDouble();
            empleado[i] = new Empleado();
            empleado[i].setNombre(nombreE);
            empleado[i].setGenero(genero);
            empleado[i].setEdad(edad);
            empleado[i].setDireccion(direccion);
            sc.nextLine();

        }

        // mostrar empleados
        for (int i = 0; i < empleado.length; i++) {
            System.out.println(empleado[i].toString());
        }

    }

}
