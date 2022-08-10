package Vista;

import java.sql.SQLException;
import java.util.ArrayList;

import Controlador.controladorReportes;
import model.vo.primerInformeVo;
import model.vo.segundoInformeVo;
import model.vo.tercerInformeVo;

public class vistaInformes {

public static final controladorReportes controlador = new controladorReportes();

public static void primerInforme() throws SQLException{
    ArrayList<primerInformeVo> infoLider = controlador.consultarPrimerInforme();

    //Encabezado del resultado
    System.out.println("Primer informe");
    System.out.println("ID_Lider  Nombre  Primer_Apellido  Ciudad_Residencia");
    try {
        infoLider.forEach(requerimiento -> {
            System.out.println(requerimiento.getIdLider()+"        "+
            requerimiento.getNombre()+"        "+
            requerimiento.getPrimerApellido()+"        "+
            requerimiento.getCiudadResidencia()+"        ");
        });
    } catch (Exception e) {
        System.err.println(e);
    }
}

public static void segundoInforme()throws SQLException{
    ArrayList<segundoInformeVo> infoProyecto = controlador.consultarSegundoInforme();

    //Encabezado del resultado
    System.out.println("Segundo Informe");
    System.out.println("ID_Proyecto  Constructora   Nùmero_Habitaciones   Ciudad");
    try {
        for(segundoInformeVo requerimiento : infoProyecto){
            System.out.println(requerimiento.getIdProyecto()+"        "+
            requerimiento.getConstructora()+"        "+
requerimiento.getNumeroHabitaciones()+"        "+
requerimiento.getCiudad()+"        "

            );
        }
    } catch (Exception e) {
        System.err.println(e);
    }
}

public static void tercerInforme()throws SQLException{
    ArrayList<tercerInformeVo> comprasProyecto = controlador.consultarTercerInforme();

    //Encabezado del resultado
    System.out.println("Tercer Informe");
    System.out.println("ID_Compra   Constructora   Banco_Vinculado");
    try {
        comprasProyecto.forEach(requerimiento -> {
            System.out.println(requerimiento.getIdCompra()+"        "+
                    requerimiento.getConstructora()+"        "+
                    requerimiento.getBancoVinculado()+"        " );
        });
    } catch (Exception e) {
        System.err.println(e);
    }
}


    
}
