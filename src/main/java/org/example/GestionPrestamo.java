package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestionPrestamo {
    private PrestamoDAO prestamoDAO;

    // Constructor que recibe la conexiónnn
    public GestionPrestamo(Connection connection) {
        this.prestamoDAO = new PrestamoDAO(connection);
    }

    // aqui registramos el prestamo
    public void registrarPrestamo(Prestamo prestamo) {
        try {
            //llamamos al dao para registrar
            prestamoDAO.registrarPrestamo(prestamo);
            System.out.println(" registrado bien");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error  " + e.getMessage());
        }
    }

    // por id aqui
    public Prestamo obtenerPrestamoPorId(int id) {
        try {
            //obtenemos el prestamo desdeee el dao
            return prestamoDAO.obtenerPrestamoPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener  " + e.getMessage());
            return null;
        }
    }

    //la arraylist para listar a todos los que nos surgan de prestamos
    public List<Prestamo> listarPrestamos() {
        try {
            //lo llamo ewn todos igual para redireccionar al dao
            return prestamoDAO.listarPrestamos();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al listar  " + e.getMessage());
            return null;
        }
    }

    // aqui actualizamos los prestamos ante cualquier cambio
    public void actualizarPrestamo(Prestamo prestamo) {
        try {
            prestamoDAO.actualizarPrestamo(prestamo);
            System.out.println("actualizado ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error  " + e.getMessage());
        }
    }

    //aqui eliminamos por id

    public void eliminarPrestamo(int id) {
        try {
            prestamoDAO.eliminarPrestamo(id);
            System.out.println("eliminado");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error" + e.getMessage());
        }
    }
}
