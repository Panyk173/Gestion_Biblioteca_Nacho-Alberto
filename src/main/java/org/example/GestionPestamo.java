package org.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class GestionPrestamo {

        // DAO de préstamo para realizar las operaciones CRUD
        private PrestamoDAO prestamoDAO;

        // Constructor que recibe la conexión
        public GestionPrestamo(Connection connection) {
            this.prestamoDAO = new PrestamoDAO(connection);
        }

        // Método para registrar un nuevo préstamo
        public void registrarPrestamo(Prestamo prestamo) {
            try {
                prestamoDAO.registrarPrestamo(prestamo); // Llamamos al DAO para registrar el préstamo
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para obtener un préstamo por su ID
        public Prestamo obtenerPrestamoPorId(int id) {
            try {
                return prestamoDAO.obtenerPrestamoPorId(id); // Obtenemos el préstamo desde el DAO
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        // Método para actualizar un préstamo
        public void actualizarPrestamo(Prestamo prestamo) {
            try {
                prestamoDAO.actualizarPrestamo(prestamo); // Actualizamos el préstamo a través del DAO
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para eliminar un préstamo por su ID
        public void eliminarPrestamo(int id) {
            try {
                prestamoDAO.eliminarPrestamo(id); // Llamamos al DAO para eliminar el préstamo
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para listar todos los préstamos
        public List<Prestamo> listarPrestamos() {
            try {
                return prestamoDAO.listarPrestamos(); // Obtenemos la lista de préstamos desde el DAO
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


