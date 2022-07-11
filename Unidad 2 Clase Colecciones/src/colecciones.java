import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class colecciones {
    public static void main(String[] args) throws Exception {
         // TODO code application logic here
         Scanner sc = new Scanner(System.in);
         //Colecciones
         //Listas
         List<Integer> listaEnteros = new ArrayList<>();
         
         //Adicionar pos asignación
         listaEnteros.add(8);
         
         System.out.println(listaEnteros.get(0));
         
         System.out.println("De forma dinámica...");
         System.out.println("Digite la cantidad de números que desea añadir a la lista");
         int nL = sc.nextInt();
         
         for (int i = 0; i < nL; i++) {
             System.out.print("Digite el número "+(i+1)+" : ");
             int numero = sc.nextInt();
             listaEnteros.add(numero);
         }
         System.out.println("");
         
         System.out.println("Mostrar lista de forma convencional");
         
         for (int i = 0; i < listaEnteros.size(); i++) {
             System.out.println(listaEnteros.get(i));
         }
         
         System.out.println("Otra forma foreach");
         
         for (Integer i: listaEnteros) {
             System.out.println(i);
         }
         
         
         System.out.println("Tamaño de la lista: "+listaEnteros.size());
         
         System.out.println("Digite el número a buscar");
         int numeroB = sc.nextInt();
         
         if (listaEnteros.contains(numeroB)) {
             System.out.println("El número "+numeroB+ " SI se encuentra en la lista");
         }else{
             System.out.println("El número "+numeroB+ " NO se encuentra en la lista");
         }
         
         System.out.println("Digite el número a eliminar de la lista");
         int nE = sc.nextInt();
         
         listaEnteros.remove(new Integer(nE));
         
         System.out.println("Nueva lista sin el número");
         
         for (Integer i: listaEnteros) {
             System.out.println(i);
         }
         
         
         
         
         
    sc.close();     
    }
}
