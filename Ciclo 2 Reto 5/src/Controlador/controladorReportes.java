package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.primerInformeDao;
import model.dao.segundoInformeDao;
import model.dao.tercerInformeDao;
import model.vo.primerInformeVo;
import model.vo.segundoInformeVo;
import model.vo.tercerInformeVo;

public class controladorReportes {

    private final primerInformeDao primerinforme;
    private final segundoInformeDao segundoinforme;
    private final tercerInformeDao tercerinforme;

    public controladorReportes() {
        this.primerinforme = new primerInformeDao();
        this.segundoinforme = new segundoInformeDao();
        this.tercerinforme = new tercerInformeDao();

    }

    public ArrayList<primerInformeVo> consultarPrimerInforme() throws SQLException {
        return this.primerinforme.consultarPrimerInforme();
    }

    public ArrayList<segundoInformeVo> consultarSegundoInforme() throws SQLException {
        return this.segundoinforme.consultarSegundoInforme();
    }

    public ArrayList<tercerInformeVo> consultarTercerInforme() throws SQLException {
        return this.tercerinforme.consultarTercerInforme();
    }
}


    

