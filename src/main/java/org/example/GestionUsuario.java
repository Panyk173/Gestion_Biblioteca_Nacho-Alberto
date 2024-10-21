package org.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class GestionUsuario {

        // DAO de usuario para realizar las operaciones CRUD
        private UsuarioDAO usuarioDAO;

        // Constructor que recibe la conexión
        public GestionUsuario(Connection connection) {
            this.usuarioDAO = new UsuarioDAO(connection);
        }

        // Método para agregar un nuevo usuario
        public void agregarUsuario(Usuario usuario) {
            try {
                usuarioDAO.crearUsuario(usuario); // Llamamos al DAO para agregar el usuario
                System.out.println("Usuario agregado con éxito.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al agregar el usuario: " + e.getMessage());
            }
        }

        // Método para obtener un usuario por su ID
        public Usuario obtenerUsuarioPorId(int id) {
            try {
                return usuarioDAO.obtenerUsuarioPorId(id); // Obtenemos el usuario desde el DAO
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al obtener el usuario: " + e.getMessage());
                return null;
            }
        }

        // Método para listar todos los usuarios
        public List<Usuario> listarUsuarios() {
            try {
                return usuarioDAO.leerUsuarios(); // Llamamos al DAO para obtener todos los usuarios
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al listar los usuarios: " + e.getMessage());
                return null;
            }
        }

        // Método para actualizar un usuario
        public void actualizarUsuario(Usuario usuario) {
            try {
                usuarioDAO.actualizarUsuario(usuario); // Llamamos al DAO para actualizar el usuario
                System.out.println("Usuario actualizado con éxito.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al actualizar el usuario: " + e.getMessage());
            }
        }

        // Método para eliminar un usuario por su ID
        public void eliminarUsuario(int id) {
            try {
                usuarioDAO.eliminarUsuario(id); // Llamamos al DAO para eliminar el usuario
                System.out.println("Usuario eliminado con éxito.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al eliminar el usuario: " + e.getMessage());
            }
        }
    }


