package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    // Conexión a la base de datos
    private Connection connection;

    // Constructor que recibe la conexión
    public AutorDAO(Connection connection) {
        this.connection = connection;
    }

    // Mwetodo para añadir un Autor a la base de datos
    public void agregarAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO Autor (nombre) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, autor.getNombre()); // Añadimos el nombre
            stmt.executeUpdate(); // Ejecutamos la consulta
        }
    }

    // Metodo para leer un Autor de la base de datos por su ID
    public Autor obtenerAutorPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Autor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Le pasamos el ID
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Autor(
                            rs.getInt("id"),
                            rs.getString("nombre")
                    );
                }
            }
        }
        return null; // Si no lo encuentra, devolvemos null
    }

    // Metodo para actualizar un Autor
    public void actualizarAutor(Autor autor) throws SQLException {
        String sql = "UPDATE Autor SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, autor.getNombre()); // Actualizamos el nombre
            stmt.setInt(2, autor.getId()); // Usamos el ID para buscar el autor
            stmt.executeUpdate(); // Ejecutamos la consulta
        }
    }

    // Metodo para eliminar un Autor de la base de datos
    public void eliminarAutor(int id) throws SQLException {
        String sql = "DELETE FROM Autor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Borramos el autor por su ID
            stmt.executeUpdate(); // Ejecutamos la consulta
        }
    }

    // Metodo para listar todos los Autores
    public List<Autor> listarAutores() throws SQLException {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autores.add(new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
        }
        return autores; // Devolvemos la lista de Autores
    }
}
