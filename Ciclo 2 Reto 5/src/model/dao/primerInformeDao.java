package model.dao;

import model.vo.primerInformeVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UtilReto5.JDBCUtilities;

/*Generar un informe basándose en la tabla con la información respectiva al “Líder”. El
listado debe contener: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia.
Este informe debe estar ordenado por la “Ciudad_Residencia” de forma alfabética.*/

public class primerInformeDao {

    public ArrayList<primerInformeVo> consultarPrimerInforme() throws SQLException {
        ArrayList<primerInformeVo> resultado = new ArrayList<primerInformeVo>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String query = "SELECT Lider.ID_Lider, Lider.Nombre, Lider.Primer_Apellido" +
                    ", Lider.Ciudad_Residencia FROM Lider ORDER BY Lider.Ciudad_Residencia";

            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                primerInformeVo requerimiento = new primerInformeVo();
                requerimiento.setIdLider(resultSet.getInt("ID_Lider"));
                requerimiento.setNombre(resultSet.getString("Nombre"));
                requerimiento.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                requerimiento.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));

                resultado.add(requerimiento);
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            System.err.println("Excepcion: consulta no posible de responder " + e);
        }

        return resultado;
    }

}
