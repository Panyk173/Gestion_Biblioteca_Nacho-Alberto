package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GestionUsuario {

    private UsuarioDAO usuarioDAO;

    public GestionUsuario(Connection connection) {
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    // menu CRUD para usuarios
    public void menuGestionUsuarios(Scanner scanner) {
        int opcion;
        do {
            System.out.println("gestion de usuarios");
            System.out.println("1. agregar usuario");
            System.out.println("2. actualizar usuario");
            System.out.println("3. eliminar usuario");
            System.out.println("4. listar usuarios");
            System.out.println("0. volver al menu principal");
            System.out.print("elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiamos el buffer

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner);
                    break;
                case 2:
                    actualizarUsuario(scanner);
                    break;
                case 3:
                    eliminarUsuario(scanner);
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("menu principal");
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        } while (opcion != 0);
    }

    // metodo para agregar un usuario
    private void agregarUsuario(Scanner scanner) {
        System.out.println("agregar usuario");
        System.out.print("introduce el nombre  ");
        String nombre = scanner.nextLine();

        Usuario usuario = new Usuario(0, nombre);
        try {
            usuarioDAO.crearUsuario(usuario);
            System.out.println("usuario agregado");
        } catch (SQLException e) {
            System.out.println("error ");
            e.printStackTrace();
        }
    }

    // actualizar un usuario
    private void actualizarUsuario(Scanner scanner) {
        System.out.println("actualizar usuario");
        System.out.print("introduce el id del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiamos el buffer

        System.out.print("introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre);
        try {
            usuarioDAO.actualizarUsuario(usuario);
            System.out.println("usuario actualizado ");
        } catch (SQLException e) {
            System.out.println("error ");
            e.printStackTrace();
        }
    }

    //  eliminar un usuario
    private void eliminarUsuario(Scanner scanner) {
        System.out.println("eliminar usuario");
        System.out.print("introduce el id del usuario a eliminar: ");
        int id = scanner.nextInt();
        try {
            usuarioDAO.eliminarUsuario(id);
            System.out.println("usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("error ");
            e.printStackTrace();
        }
    }

    //  listar usuarios
    private void listarUsuarios() {
        System.out.println("listar usuarios");
        try {
            List<Usuario> usuarios = usuarioDAO.leerUsuarios();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getId() + ": " + usuario.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("error al listar ");
            e.printStackTrace();
        }
    }
}
