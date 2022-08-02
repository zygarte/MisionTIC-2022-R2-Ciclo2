import view.ReportesView;

public class Reto_4 {
    public static void main(String[] args) throws Exception {

        //1. Información de los proyectos financiados por un banco determinado (consulta 2 del reto 3).

        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);

        //2. Listado del total adeudado en cada proyecto, filtrado por un límite inferior dado (consulta 4 del reto 3).

        var reportesView2 = new ReportesView();
        var limiteInferior = 50_000d;
        reportesView2.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);

        //3. Listado del top 10 de los líderes que más dinero gastan en sus proyectos para la compra de materiales (consulta 5 del reto 3).

        var reportesView3 = new ReportesView();
        reportesView3. lideresQueMasGastan();
        

    }
}
