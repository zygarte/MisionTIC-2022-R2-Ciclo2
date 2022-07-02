//Importante: En la plataforma de iMaster se sube esta clase SIN MAIN.
//Se indica esta sección para probar localmente antes de someter a revisión.


public class Reto01 {
    public static void main(String[] args) throws Exception {
        // Llamados para verificar con los casos de prueba el funcionamiento de la clase

        System.out.println("Caso 1");
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        System.out.println(becaUniversitaria.calcularInteresSimple());
        System.out.println(becaUniversitaria.calcularInteresCompuesto());
        System.out.println(becaUniversitaria.compararInversion(60,13000,1.4));

        System.out.println("Caso 2");
        BecaUniversitaria becaUniversitaria2 = new BecaUniversitaria(48,10000,2.0);
        System.out.println(becaUniversitaria2.calcularInteresSimple());
        System.out.println(becaUniversitaria2.calcularInteresCompuesto());
        System.out.println(becaUniversitaria2.compararInversion());
        
        System.out.println("Caso 3");
        BecaUniversitaria becaUniversitaria3 = new BecaUniversitaria();
        System.out.println(becaUniversitaria3.calcularInteresSimple());
        System.out.println(becaUniversitaria3.calcularInteresCompuesto());
        System.out.println(becaUniversitaria3.compararInversion());
        



        
    }
}
