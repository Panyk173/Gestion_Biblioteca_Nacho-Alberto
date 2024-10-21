package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GestionLibro {

    private LibroDAO libroDAO;

    public GestionLibro(Connection connection) {
        this.libroDAO = new LibroDAO(connection);
    }

    // menu CRUD para libros
    public void menuGestionLibros(Scanner scanner) {
        int opcion;
        do {
            System.out.println("= gestion de libros ");
            System.out.println("1. agregar libro");
            System.out.println("2. actualizar libro");
            System.out.println("3. eliminar libro");
            System.out.println("4. listar libros");
            System.out.println("0. volver al menu principal");
            System.out.print("elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiamos el buffer

            switch (opcion) {
                case 1:
                    agregarLibro(scanner);
                    break;
                case 2:
                    actualizarLibro(scanner);
                    break;
                case 3:
                    eliminarLibro(scanner);
                    break;
                case 4:
                    listarLibros();
                    break;
                case 0:
                    System.out.println("menu principal");
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        } while (opcion != 0);
    }

    // metodo para agregar un libro
    private void agregarLibro(Scanner scanner) {
        System.out.println(" agregar libro ");
        System.out.print("introduce el titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("introduce el isbn: ");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(0, titulo, isbn);
        try {
            libroDAO.agregarLibro(libro);
            System.out.println("libro agregado .");
        } catch (SQLException e) {
            System.out.println("error al agregar ");
            e.printStackTrace();
        }
    }

    // metodo para actualizar un libro
    private void actualizarLibro(Scanner scanner) {
        System.out.println(" actualizar libro ");
        System.out.print("introduce el id del libro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiamos el buffer

        System.out.print("introduce el nuevo titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("introduce el nuevo isbn: ");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(id, titulo, isbn);
        try {
            libroDAO.actualizarLibro(libro);
            System.out.println("libro actualizado ");
        } catch (SQLException e) {
            System.out.println("error al actualizar ");
            e.printStackTrace();
        }
    }

    // metodo para eliminar un libro
    private void eliminarLibro(Scanner scanner) {
        System.out.println(" eliminar libro ");
        System.out.print("introduce el id del libro a eliminar: ");
        int id = scanner.nextInt();
        try {
            libroDAO.eliminarLibro(id);
            System.out.println("libro eliminado");
        } catch (SQLException e) {
            System.out.println("error al eliminar");
            e.printStackTrace();
        }
    }

    // metodo para listar libros
    private void listarLibros() {
        System.out.println(" listar libros ");
        try {
            List<Libro> libros = libroDAO.listarLibros();
            for (Libro libro : libros) {
                System.out.println(libro.getId() + ": " + libro.getTitulo() + " (isbn: " + libro.getIsbn() + ")");
            }
        } catch (SQLException e) {
            System.out.println("error al listar ");
            e.printStackTrace();
        }
    }
}
