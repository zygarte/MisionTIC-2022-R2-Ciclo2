package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.ComprasDeLiderVo;
import util.JDBCUtilities;

public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> listarComprasDeLider() throws SQLException {
        List<ComprasDeLiderVo> listado = new ArrayList<>();
        var connection = JDBCUtilities.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {

            var query = " SELECT (l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido) AS LIDER,"
                    + " SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR"
                    + " FROM Proyecto p"
                    + " INNER JOIN Compra c ON c.ID_Proyecto = p.ID_Proyecto"
                    + " INNER JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion"
                    + " INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider"
                    + " GROUP BY LIDER"
                    + " ORDER BY VALOR DESC"
                    + " LIMIT 10;";

            statement = connection.prepareStatement(query);
            result = statement.executeQuery();

            
            while (result.next()) {
                var vo = new ComprasDeLiderVo();
                vo.setLider(result.getString("LIDER"));
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
