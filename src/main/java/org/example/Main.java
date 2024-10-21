package org.example;

import java.sql.Connection;
import java.sql.SQLException;
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

            // Creamos un menú para que el usuario elija una opción
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("=== gestion de biblioteca ===");
                System.out.println("1. gestionar libros");
                System.out.println("2. gestionar autores");
                System.out.println("3. gestionar usuarios");
                System.out.println("4. gestionar prestamos");
                System.out.println("0. salir");
                System.out.print("elige una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiamos el buffer

                switch (opcion) {
                    case 1:
                        gestionLibro.menuGestionLibros(scanner);
                        break;
                    case 2:
                        gestionAutor.menuGestionAutores(scanner);
                        break;
                    case 3:
                        gestionUsuario.menuGestionUsuarios(scanner);
                        break;
                    case 4:
                        gestionPrestamo.menuGestionPrestamos(scanner);
                        break;
                    case 0:
                        System.out.println("salir");
                        break;
                    default:
                        System.out.println("opcion no valida.");
                }
            } while (opcion != 0);

            // Cerramos el scanner y la conexión
            scanner.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
