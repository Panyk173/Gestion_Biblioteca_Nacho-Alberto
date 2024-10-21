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

        // Método para agregar un usuario
        public void agregarUsuario(Usuario usuario) {
            try {
                usuarioDAO.agregarUsuario(usuario); // Llamamos al DAO para agregar el usuario
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para obtener un usuario por su ID
        public Usuario obtenerUsuarioPorId(int id) {
            try {
                return usuarioDAO.obtenerUsuarioPorId(id); // Obtenemos el usuario desde el DAO
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        // Método para actualizar un usuario
        public void actualizarUsuario(Usuario usuario) {
            try {
                usuarioDAO.actualizarUsuario(usuario); // Actualizamos el usuario a través del DAO
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para eliminar un usuario por su ID
        public void eliminarUsuario(int id) {
            try {
                usuarioDAO.eliminarUsuario(id); // Llamamos al DAO para eliminar el usuario
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para listar todos los usuarios
        public List<Usuario> listarUsuarios() {
            try {
                return usuarioDAO.listarUsuarios(); // Obtenemos la lista de usuarios desde el DAO
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


