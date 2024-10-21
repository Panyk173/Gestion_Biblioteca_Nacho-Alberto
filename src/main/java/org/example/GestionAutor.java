package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GestionAutor {

    private AutorDAO autorDAO;

    public GestionAutor(Connection connection) {
        this.autorDAO = new AutorDAO(connection);
    }

    // menu CRUD para autores
    public void menuGestionAutores(Scanner scanner) {
        int opcion;
        do {
            System.out.println("=== gestion de autores ===");
            System.out.println("1. agregar autor");
            System.out.println("2. actualizar autor");
            System.out.println("3. eliminar autor");
            System.out.println("4. listar autores");
            System.out.println("0. volver al menu principal");
            System.out.print("elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiamos el buffer

            switch (opcion) {
                case 1:
                    agregarAutor(scanner);
                    break;
                case 2:
                    actualizarAutor(scanner);
                    break;
                case 3:
                    eliminarAutor(scanner);
                    break;
                case 4:
                    listarAutores();
                    break;
                case 0:
                    System.out.println("volviendo al menu principal...");
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        } while (opcion != 0);
    }

    // metodo para agregar un autor
    private void agregarAutor(Scanner scanner) {
        System.out.println("=== agregar autor ===");
        System.out.print("introduce el nombre del autor: ");
        String nombre = scanner.nextLine();

        Autor autor = new Autor(0, nombre);
        try {
            autorDAO.agregarAutor(autor);
            System.out.println("autor agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("error al agregar el autor.");
            e.printStackTrace();
        }
    }

    // metodo para actualizar un autor
    private void actualizarAutor(Scanner scanner) {
        System.out.println("=== actualizar autor ===");
        System.out.print("introduce el id del autor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiamos el buffer

        System.out.print("introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();

        Autor autor = new Autor(id, nombre);
        try {
            autorDAO.actualizarAutor(autor);
            System.out.println("autor actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("error al actualizar el autor.");
            e.printStackTrace();
        }
    }

    // metodo para eliminar un autor
    private void eliminarAutor(Scanner scanner) {
        System.out.println("=== eliminar autor ===");
        System.out.print("introduce el id del autor a eliminar: ");
        int id = scanner.nextInt();
        try {
            autorDAO.eliminarAutor(id);
            System.out.println("autor eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("error al eliminar el autor.");
            e.printStackTrace();
        }
    }

    // metodo para listar autores
    private void listarAutores() {
        System.out.println("=== listar autores ===");
        try {
            List<Autor> autores = autorDAO.listarAutores();
            for (Autor autor : autores) {
                System.out.println(autor.getId() + ": " + autor.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("error al listar los autores.");
            e.printStackTrace();
        }
    }
}
