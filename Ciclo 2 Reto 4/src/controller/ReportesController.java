package controller;

import java.sql.SQLException;
import java.util.List;

import model.dao.ComprasDeLiderDao;
import model.dao.DeudasPorProyectoDao;
import model.dao.ProyectoBancoDao;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

public class ReportesController {

    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ProyectoBancoVo> listarProyectoBanco(String banco) throws SQLException {
        return proyectoBancoDao.listarProyectosPorBanco(banco);
    }

    public List<DeudasPorProyectoVo> listarDeudaProyecto(Double limiteInferior) throws SQLException {
        return deudasPorProyectoDao.listarDeudaProyecto(limiteInferior);
    }

    public List<ComprasDeLiderVo> listarComprasDeLider() throws SQLException {
        return comprasDeLiderDao.listarComprasDeLider();
    }

}
