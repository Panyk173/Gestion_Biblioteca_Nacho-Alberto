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
            System.out.println("Préstamo registrado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al registrar el préstamo: " + e.getMessage());
        }
    }

    // Método para obtener un préstamo por su ID
    public Prestamo obtenerPrestamoPorId(int id) {
        try {
            return prestamoDAO.obtenerPrestamoPorId(id); // Obtenemos el préstamo desde el DAO
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el préstamo: " + e.getMessage());
            return null;
        }
    }

    // Método para listar todos los préstamos
    public List<Prestamo> listarPrestamos() {
        try {
            return prestamoDAO.listarPrestamos(); // Llamamos al DAO para obtener todos los préstamos
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al listar los préstamos: " + e.getMessage());
            return null;
        }
    }

    // Método para actualizar un préstamo
    public void actualizarPrestamo(Prestamo prestamo) {
        try {
            prestamoDAO.actualizarPrestamo(prestamo); // Llamamos al DAO para actualizar el préstamo
            System.out.println("Préstamo actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al actualizar el préstamo: " + e.getMessage());
        }
    }

    // Método para eliminar un préstamo por su ID
    public void eliminarPrestamo(int id) {
        try {
            prestamoDAO.eliminarPrestamo(id); // Llamamos al DAO para eliminar el préstamo
            System.out.println("Préstamo eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al eliminar el préstamo: " + e.getMessage());
        }
    }
}
