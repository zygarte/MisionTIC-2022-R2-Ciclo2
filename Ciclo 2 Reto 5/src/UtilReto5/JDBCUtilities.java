package UtilReto5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    // Atributos de clase para gestión de conexión con la base de datos
    // private static final String UBICACION_BD = "ProyectosConstruccion.db";
    private static final String UBICACION_BD = "Ciclo 2 Reto 5\\src\\target\\ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }

}
