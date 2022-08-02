package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.DeudasPorProyectoVo;
import util.JDBCUtilities;

public class DeudasPorProyectoDao {

    public List<DeudasPorProyectoVo> listarDeudaProyecto(Double limiteInferior) throws SQLException {
        List<DeudasPorProyectoVo> listado = new ArrayList<>();

        var connection = JDBCUtilities.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            var query = " SELECT p.ID_Proyecto ID, SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR"
            + " FROM Proyecto p"
            + " INNER JOIN Compra c ON c.ID_Proyecto = p.ID_Proyecto"
            + " INNER JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion"
            + " WHERE c.Pagado = 'No'"
            + " GROUP BY p.ID_Proyecto"
            + " HAVING SUM(c.Cantidad*mc.Precio_Unidad) > ?"
            + " ORDER BY VALOR DESC;";

            statement = connection.prepareStatement(query);
            statement.setDouble(1, limiteInferior);
            result = statement.executeQuery();

            while (result.next()) {
                var vo = new DeudasPorProyectoVo();
                vo.setId(result.getInt("ID"));
                vo.setValor(result.getDouble("VALOR"));
                listado.add(vo);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (result != null) {
                result.close();
            }
        }
        return listado;

    }

}
