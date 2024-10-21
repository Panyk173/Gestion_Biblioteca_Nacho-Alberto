package org.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

    public class GestionUsuario {

        //el dao principal
        private UsuarioDAO usuarioDAO;

        // aqui recibimos la conexion
        public GestionUsuario(Connection connection) {
            this.usuarioDAO = new UsuarioDAO(connection);
        }

        //aqui agregamos con este metodo a los usuarios
        public void agregarUsuario(Usuario usuario) {
            try {
                usuarioDAO.crearUsuario(usuario);
                System.out.println("Usuario agregado");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error  " + e.getMessage());
            }
        }

        // aqui tio por id obtenemos
        public Usuario obtenerUsuarioPorId(int id) {
            try {
                return usuarioDAO.obtenerUsuarioPorId(id);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error  " + e.getMessage());
                return null;
            }
        }

        // listar usuarios
        public List<Usuario> listarUsuarios() {
            try {
                return usuarioDAO.leerUsuarios();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error  " + e.getMessage());
                return null;
            }
        }

        // metodo de actualizar
        public void actualizarUsuario(Usuario usuario) {
            try {
                usuarioDAO.actualizarUsuario(usuario);
                System.out.println("Usuario ");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error " + e.getMessage());
            }
        }

        // aqui el metodo de eliminar vale?
        public void eliminarUsuario(int id) {
            try {
                usuarioDAO.eliminarUsuario(id);
                System.out.println("Usuario eliminado ");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error  " + e.getMessage());
            }
        }
    }


