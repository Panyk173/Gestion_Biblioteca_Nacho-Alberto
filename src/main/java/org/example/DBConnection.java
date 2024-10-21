package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Metodo para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/biblioteca"; // Cambia el nombre de la base de datos si es diferente
        String user = "root"; // Nombre de usuario de la base de datos
        String password = ""; // Contraseña de la base de datos
        return DriverManager.getConnection(url, user, password); // Devolvemos la conexión
    }
}
