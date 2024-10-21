package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GestionPrestamo {

    private PrestamoDAO prestamoDAO;
    private GestionUsuario gestionUsuario;
    private GestionLibro gestionLibro;

    public GestionPrestamo(Connection connection) {
        this.prestamoDAO = new PrestamoDAO(connection);
    }

    // menu CRUD para prestamos
    public void menuGestionPrestamos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("=== gestion de prestamos ===");
            System.out.println("1. agregar prestamo");
            System.out.println("2. actualizar prestamo");
            System.out.println("3. eliminar prestamo");
            System.out.println("4. listar prestamos");
            System.out.println("0. volver al menu principal");
            System.out.print("elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiamos el buffer

            switch (opcion) {
                case 1:
                    agregarPrestamo(scanner);
                    break;
                case 2:
                    actualizarPrestamo(scanner);
                    break;
                case 3:
                    eliminarPrestamo(scanner);
                    break;
                case 4:
                    listarPrestamos();
                    break;
                case 0:
                    System.out.println("volviendo al menu principal...");
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        } while (opcion != 0);
    }

    // metodo para agregar un prestamo
    private void agregarPrestamo(Scanner scanner) {
        System.out.println("=== agregar prestamo ===");
        System.out.print("introduce el id del usuario: ");
        int idUsuario = scanner.nextInt();
        System.out.print("introduce el id del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine(); // limpiamos el buffer

        System.out.print("introduce la fecha de inicio (yyyy-mm-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("introduce la fecha de fin (yyyy-mm-dd): ");
        String fechaFin = scanner.nextLine();

        try {
            Usuario usuario = UsuarioDAO.obtenerUsuarioPorId(idUsuario);
            Libro libro = LibroDAO.obtenerLibroPorId(idLibro);
            Prestamo prestamo = new Prestamo(0, java.sql.Date.valueOf(fechaInicio), java.sql.Date.valueOf(fechaFin), usuario, libro);
            PrestamoDAO.registrarPrestamo(prestamo);
            System.out.println("prestamo agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("error al agregar el prestamo.");
            e.printStackTrace();
        }
    }

    // metodo para actualizar un prestamo
    private void actualizarPrestamo(Scanner scanner) {
        System.out.println("=== actualizar prestamo ===");
        System.out.print("introduce el id del prestamo a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiamos el buffer

        System.out.print("introduce la nueva fecha de inicio (yyyy-mm-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("introduce la nueva fecha de fin (yyyy-mm-dd): ");
        String fechaFin = scanner.nextLine();

        try {
            Prestamo prestamo = prestamoDAO.obtenerPrestamoPorId(id);
            prestamo.setFechaInicio(java.sql.Date.valueOf(fechaInicio));
            prestamo.setFechaFin(java.sql.Date.valueOf(fechaFin));
            prestamoDAO.actualizarPrestamo(prestamo);
            System.out.println("prestamo actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("error al actualizar el prestamo.");
            e.printStackTrace();
        }
    }

    // metodo para eliminar un prestamo
    private void eliminarPrestamo(Scanner scanner) {
        System.out.println("=== eliminar prestamo ===");
        System.out.print("introduce el id del prestamo a eliminar: ");
        int id = scanner.nextInt();
        try {
            prestamoDAO.eliminarPrestamo(id);
            System.out.println("prestamo eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("error al eliminar el prestamo.");
            e.printStackTrace();
        }
    }

    // metodo para listar prestamos
    private void listarPrestamos() {
        System.out.println("=== listar prestamos ===");
        try {
            List<Prestamo> prestamos = prestamoDAO.listarPrestamos();
            for (Prestamo prestamo : prestamos) {
                System.out.println("id: " + prestamo.getId() + ", usuario: " + prestamo.getUsuario().getNombre() + ", libro: " + prestamo.getLibro().getTitulo());
            }
        } catch (SQLException e) {
            System.out.println("error al listar los prestamos.");
            e.printStackTrace();
        }
    }
}
