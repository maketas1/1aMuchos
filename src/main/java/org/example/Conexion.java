package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/db_empleados";
    private static final String usuario = "root";
    private static final String clave = "";

    private static Connection conexion = null;

    public static Connection getConexion() throws SQLException {
        if (conexion == null) {
            conexion = DriverManager.getConnection(url, usuario, clave);
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexion = null;
    }
}
