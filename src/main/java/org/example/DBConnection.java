package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Metodo para obtener la conexión a la base de datos Biblioteca
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
