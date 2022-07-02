public class BecaUniversitaria {
// -----------------------------------------------------------------
    // Atributos
// -----------------------------------------------------------------
    public double pMonto;
    public double pInteres;
    public int pTiempo;
// -----------------------------------------------------------------
    // Constructores
// -----------------------------------------------------------------
    public BecaUniversitaria(){
        pMonto = 0.0;
        pInteres = 0.0;
        pTiempo = 0;
    }
    

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres){
        this.pMonto = pMonto;
        this.pInteres = pInteres;
        this.pTiempo = pTiempo;
    }
// -----------------------------------------------------------------
    // Métodos
// -----------------------------------------------------------------
    public double calcularInteresSimple( ){
        double interesSimple = pMonto * (pInteres/100)*pTiempo;
        interesSimple = Math.round(interesSimple);
        return interesSimple;
        }

    public double calcularInteresCompuesto( ){
        double interesCompuesto = pMonto * (Math.pow((1+ pInteres/100), pTiempo)-1);
        interesCompuesto = Math.round(interesCompuesto);
        return interesCompuesto;
        }

    public String compararInversion (int pTiempo, double pMonto, double pInteres){
        double interesSimple = pMonto * (pInteres/100)*pTiempo;
        interesSimple = Math.round(interesSimple);
        double interesCompuesto = pMonto * (Math.pow((1+ pInteres/100), pTiempo)-1);
        interesCompuesto = Math.round(interesCompuesto);
        double compararInversion = interesCompuesto - interesSimple;
        if(compararInversion>0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + compararInversion;
        }else{
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";

        }
        
        }

    public String compararInversion ( ){
        double interesSimple = pMonto * (pInteres/100)*pTiempo;
        interesSimple = Math.round(interesSimple);
        double interesCompuesto = pMonto * (Math.pow((1+ pInteres/100), pTiempo)-1);
        interesCompuesto = Math.round(interesCompuesto);
        double compararInversion = interesCompuesto - interesSimple;
        if(compararInversion>0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + compararInversion;
        }else{
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";

        }
        
        } 
}
