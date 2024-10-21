package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    // Guardamos la conexión a la base de datos
    private Connection connection;

    // Constructor que recibe la conexión
    public LibroDAO(Connection connection) {
        this.connection = connection;
    }

    // Metodo para añadir un Libro a la base de datos
    public void agregarLibro(Libro libro) throws SQLException {
        String sql = "INSERT INTO Libro (titulo, isbn) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo()); // Añadimos el título
            stmt.setString(2, libro.getIsbn());   // Añadimos el ISBN
            stmt.executeUpdate(); // Ejecutamos la consulta
        }
    }

    // Metodo para leer un Libro de la base de datos por su ID
    public Libro obtenerLibroPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Libro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Le pasamos el ID
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Libro(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("isbn")
                    );
                }
            }
        }
        return null; // Si no lo encuentra, devolvemos null
    }

    // Metodo para actualizar un Libro
    public void actualizarLibro(Libro libro) throws SQLException {
        String sql = "UPDATE Libro SET titulo = ?, isbn = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo()); // Actualizamos el título
            stmt.setString(2, libro.getIsbn());   // Actualizamos el ISBN
            stmt.setInt(3, libro.getId());        // Usamos el ID para buscar el libro
            stmt.executeUpdate(); // Ejecutamos la consulta
        }
    }

    // Metodo para eliminar un Libro de la base de datos
    public void eliminarLibro(int id) throws SQLException {
        String sql = "DELETE FROM Libro WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // Borramos el libro por su ID
            stmt.executeUpdate(); // Ejecutamos la consulta
        }
    }

    // Metodo para listar todos los Libros
    public List<Libro> listarLibros() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                libros.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("isbn")
                ));
            }
        }
        return libros; // Devolvemos la lista de Libros
    }
}
