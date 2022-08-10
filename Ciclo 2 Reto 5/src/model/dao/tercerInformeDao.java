package model.dao;

import model.vo.tercerInformeVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UtilReto5.JDBCUtilities;

/*Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor
“Homecenter” y para la ciudad “Salento”. Este informe debe incluir: ID_Compra,
 Constructora y Banco_Vinculado*/

public class tercerInformeDao {

    public ArrayList<tercerInformeVo> consultarTercerInforme() throws SQLException {

        ArrayList<tercerInformeVo> resultado = new ArrayList<tercerInformeVo>();
        Connection conexion = JDBCUtilities.getConnection();
        try {

            String query = "SELECT Compra.ID_Compra, Proyecto.Constructora, Proyecto.Banco_Vinculado FROM Compra"
                    + " INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto"
                    + " WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento'";

            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tercerInformeVo requerimiento = new tercerInformeVo();
                requerimiento.setIdCompra(resultSet.getInt("ID_Compra"));
                requerimiento.setConstructora(resultSet.getString("Constructora"));
                requerimiento.setBancoVinculado(resultSet.getString("Banco_Vinculado"));

                resultado.add(requerimiento);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Excepcion: consulta no posible de responder" + e);

        }

        return resultado;
    }

}
