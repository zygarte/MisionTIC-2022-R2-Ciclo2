package view;

import java.sql.SQLException;

import controller.ReportesController;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

public class ReportesView {

    private ReportesController reportesController;

    public ReportesView() {
        reportesController = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {

        try {
            System.out.println(repitaCaracter('=', 36) + "LISTADO DE PROYECTOS POR BANCO" + repitaCaracter('=', 37));
            if (banco != null && !banco.isBlank()) {
                System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD",
                        "CLASIFICACION", "ESTRATO", "LIDER"));
                System.out.println(repitaCaracter('-', 105));
            }

            // TODO Imprimir en pantalla la información del proyecto

            var lista = reportesController.listarProyectoBanco(banco);
            for (ProyectoBancoVo proyecto : lista) {
                System.out.printf("%3d %-25s %-20s %-15s %7d %-30s %n", proyecto.getIdProyecto(),
                        proyecto.getConstructora(), proyecto.getCiudad(), proyecto.getClasificacion(),
                        proyecto.getEstrato(), proyecto.getLider());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        try {
            System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO " + repitaCaracter('=', 1));
            if (limiteInferior != null) {
                System.out.println(String.format("%3s %15s", "ID", "VALOR "));
                System.out.println(repitaCaracter('-', 29));
            }
            // TODO Imprimir en pantalla la información del total adeudado
            var lista = reportesController.listarDeudaProyecto(limiteInferior);
            for (DeudasPorProyectoVo proyecto : lista) {
                System.out.printf("%3d %,15.1f %n", proyecto.getId(), proyecto.getValor());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public void lideresQueMasGastan() {
        try {
            System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                    + repitaCaracter('=', 7));
            System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
            System.out.println(repitaCaracter('-', 41));

            // TODO Imprimir en pantalla la información de los líderes

            var lista = reportesController.listarComprasDeLider();
            for (ComprasDeLiderVo proyecto : lista) {
                System.out.printf("%-25s %,15.1f %n", proyecto.getLider(), proyecto.getValor());
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }

}
