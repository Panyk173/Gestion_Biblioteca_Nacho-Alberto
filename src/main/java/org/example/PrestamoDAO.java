package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    private Connection conexion;

    // Constructor que inicializa el DAO con la conexión
    public PrestamoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para registrar un nuevo préstamo en la base de datos
    public void registrarPrestamo(Prestamo prestamo) throws SQLException {
        String query = "INSERT INTO prestamo (fechaInicio, fechaFin, idUsuario, idLibro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDate(1, prestamo.getFechaInicio());
            stmt.setDate(2, prestamo.getFechaFin());
            stmt.setInt(3, prestamo.getUsuario().getId());
            stmt.setInt(4, prestamo.getLibro().getId());
            stmt.executeUpdate();
        }
    }

    // Método para obtener un préstamo por su ID
    public Prestamo obtenerPrestamoPorId(int id) throws SQLException {
        String query = "SELECT * FROM prestamo WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Date fechaInicio = rs.getDate("fechaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                int idUsuario = rs.getInt("idUsuario");
                int idLibro = rs.getInt("idLibro");

                // Obtenemos el usuario y el libro desde los DAOs correspondientes
                Usuario usuario = new UsuarioDAO(conexion).obtenerUsuarioPorId(idUsuario);
                Libro libro = new LibroDAO(conexion).obtenerLibroPorId(idLibro);

                return new Prestamo(id, fechaInicio, fechaFin, usuario, libro);
            }
        }
        return null; // Si no encuentra el préstamo, devolvemos null
    }

    // Método para obtener todos los préstamos de la base de datos
    public List<Prestamo> listarPrestamos() throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        String query = "SELECT * FROM prestamo";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                int idUsuario = rs.getInt("idUsuario");
                int idLibro = rs.getInt("idLibro");

                Usuario usuario = new UsuarioDAO(conexion).obtenerUsuarioPorId(idUsuario);
                Libro libro = new LibroDAO(conexion).obtenerLibroPorId(idLibro);

                prestamos.add(new Prestamo(id, fechaInicio, fechaFin, usuario, libro));
            }
        }
        return prestamos;
    }

    // Método para actualizar un préstamo en la base de datos
    public void actualizarPrestamo(Prestamo prestamo) throws SQLException {
        String query = "UPDATE prestamo SET fechaInicio = ?, fechaFin = ?, idUsuario = ?, idLibro = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setDate(1, prestamo.getFechaInicio());
            stmt.setDate(2, prestamo.getFechaFin());
            stmt.setInt(3, prestamo.getUsuario().getId());
            stmt.setInt(4, prestamo.getLibro().getId());
            stmt.setInt(5, prestamo.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un préstamo de la base de datos
    public void eliminarPrestamo(int id) throws SQLException {
        String query = "DELETE FROM prestamo WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
