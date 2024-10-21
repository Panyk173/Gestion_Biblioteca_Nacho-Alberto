package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class PrestamoDAO {
        private Connection conexion;  // Conexión a la base de datos

        // Constructor que inicializa el DAO con la conexión
        public PrestamoDAO(Connection conexion) {
            this.conexion = conexion;
        }

        // Método para crear un nuevo préstamo en la base de datos
        public void crearPrestamo(Prestamo prestamo) throws SQLException {
            String query = "INSERT INTO prestamo (fechaInicio, fechaFin, idUsuario, idLibro) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setDate(1, prestamo.getFechaInicio());  // Asignamos la fecha de inicio
                stmt.setDate(2, prestamo.getFechaFin());     // Asignamos la fecha de fin
                stmt.setInt(3, prestamo.getUsuario().getId());  // Asignamos el ID del usuario
                stmt.setInt(4, prestamo.getLibro().getId());    // Asignamos el ID del libro
                stmt.executeUpdate();                          // Ejecutamos la inserción en la base de datos
            }
        }

        // Método para obtener todos los préstamos de la base de datos
        public List<Prestamo> leerPrestamos() throws SQLException {
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

                    Usuario usuario = new UsuarioDAO(conexion).leerUsuario(idUsuario);
                    Libro libro = new LibroDAO(conexion).leerLibro(idLibro);

                    prestamos.add(new Prestamo(id, fechaInicio, fechaFin, usuario, libro));  // Añadimos cada préstamo a la lista
                }
            }
            return prestamos;  // Retornamos la lista de préstamos
        }

        // Método para actualizar un préstamo en la base de datos
        public void actualizarPrestamo(Prestamo prestamo) throws SQLException {
            String query = "UPDATE prestamo SET fechaInicio = ?, fechaFin = ?, idUsuario = ?, idLibro = ? WHERE id = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setDate(1, prestamo.getFechaInicio());  // Actualizamos la fecha de inicio
                stmt.setDate(2, prestamo.getFechaFin());     // Actualizamos la fecha de fin
                stmt.setInt(3, prestamo.getUsuario().getId());  // Actualizamos el usuario
                stmt.setInt(4, prestamo.getLibro().getId());    // Actualizamos el libro
                stmt.setInt(5, prestamo.getId());               // Especificamos el ID del préstamo a actualizar
                stmt.executeUpdate();                           // Ejecutamos la actualización
            }
        }

        // Método para eliminar un préstamo de la base de datos
        public void eliminarPrestamo(int id) throws SQLException {
            String query = "DELETE FROM prestamo WHERE id = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, id);  // Especificamos el ID del préstamo a eliminar
                stmt.executeUpdate();  // Ejecutamos la eliminación
            }
        }
    }


