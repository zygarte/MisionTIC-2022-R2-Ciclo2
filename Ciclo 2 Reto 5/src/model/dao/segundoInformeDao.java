package model.dao;

import model.vo.segundoInformeVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UtilReto5.JDBCUtilities;

/* Realizar un informe basándose en la información de los proyectos cuya clasificación sea
“Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y
“Barranquilla”. Este informe debe contener: el ID_Proyecto, la Constructora, el
Nùmero_Habitaciones y la respectiva Ciudad.*/

public class segundoInformeDao {

    public ArrayList<segundoInformeVo> consultarSegundoInforme() throws SQLException {
        ArrayList<segundoInformeVo> resultado = new ArrayList<segundoInformeVo>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String query = "SELECT Proyecto.ID_Proyecto, Proyecto.Constructora,"
                    + " Proyecto.Numero_Habitaciones, Proyecto.Ciudad FROM Proyecto"
                    + " WHERE Proyecto.Clasificacion = 'Casa Campestre' AND Proyecto.Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')"
                    + " ORDER BY Proyecto.Ciudad";

            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                segundoInformeVo requerimiento = new segundoInformeVo();

                requerimiento.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento.setConstructora(resultSet.getString("Constructora"));
                requerimiento.setNumeroHabitaciones(resultSet.getInt("Numero_Habitaciones"));
                requerimiento.setCiudad(resultSet.getString("Ciudad"));

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
