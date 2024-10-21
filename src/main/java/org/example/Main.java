package org.example;
//NACHETEEEE QUE NOS HEMOS HECHO EL TRABAJO TO RAPIDO GRACIAS A GIIIT Y GITHUUUB
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // Establecemos la conexión a la base de datos
            Connection connection = DBConnection.getConnection();

            // Inicializamos las clases de gestion
            GestionLibro gestionLibro = new GestionLibro(connection);
            GestionAutor gestionAutor = new GestionAutor(connection);
            GestionUsuario gestionUsuario = new GestionUsuario(connection);
            GestionPrestamo gestionPrestamo = new GestionPrestamo(connection);

            // Creamos un menuu
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println(" Gestion de Biblioteca");
                System.out.println("1. Gestionar Libros");
                System.out.println("2. Gestionar Autores");
                System.out.println("3. Gestionar Usuarios");
                System.out.println("4. Gestionar Prestamos");
                System.out.println("0. Salir");
                System.out.print("Elige una opciion: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiamos el buffer

                switch (opcion) {
                    case 1:
                        gestionarLibros(gestionLibro, scanner);
                        break;
                    case 2:
                        gestionarAutores(gestionAutor, scanner);
                        break;
                    case 3:
                        gestionarUsuarios(gestionUsuario, scanner);
                        break;
                    case 4:
                        gestionarPrestamos(gestionPrestamo, gestionUsuario, gestionLibro, scanner);
                        break;
                    case 0:
                        System.out.println("salir");
                        break;
                    default:
                        System.out.println("Opción no valida.");
                }
            } while (opcion != 0);

            scanner.close();
            connection.close(); // Cerramos la conexión al finalizar

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  gestionar cada entidad
    private static void gestionarLibros(GestionLibro gestionLibro, Scanner scanner) {
        System.out.println("=== Gestion de Libros ===");
        // Aquí se podría implementar más lógica para el CRUD de libros
        List<Libro> libros = gestionLibro.listarLibros();
        for (Libro libro : libros) {
            System.out.println(libro.getId() + ": " + libro.getTitulo() + " (ISBN: " + libro.getIsbn() + ")");
        }
    }

    private static void gestionarAutores(GestionAutor gestionAutor, Scanner scanner) {
        System.out.println("=== Gestion de Autores ===");
        // logica de ejemplo para listar autores
        List<Autor> autores = gestionAutor.listarAutores();
        for (Autor autor : autores) {
            System.out.println(autor.getId() + ": " + autor.getNombre());
        }
    }

    private static void gestionarUsuarios(GestionUsuario gestionUsuario, Scanner scanner) {
        System.out.println("Gestion de Usuarios ");
        // Lógica de ejemplo para listar usuarios
        List<Usuario> usuarios = gestionUsuario.listarUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getId() + ": " + usuario.getNombre());
        }
    }

    private static void gestionarPrestamos(GestionPrestamo gestionPrestamo, GestionUsuario gestionUsuario, GestionLibro gestionLibro, Scanner scanner) {
        System.out.println(" Gestion de Prestamos");
        // logica para listar préstamos
        List<Prestamo> prestamos = gestionPrestamo.listarPrestamos();
        for (Prestamo prestamo : prestamos) {
            System.out.println("Prestamo ID: " + prestamo.getId() + " - Usuario: " + prestamo.getUsuario().getNombre() + " - Libro: " + prestamo.getLibro().getTitulo());
        }
    }
}
