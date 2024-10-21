package org.example;
    import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class UsuarioDAO {
        private Connection conexion;  // Conexión a la base de datos

        // Constructor que inicializa el DAO con la conexión
        public UsuarioDAO(Connection conexion) {
            this.conexion = conexion;
        }

        // Método para crear un nuevo usuario en la base de datos
        public void crearUsuario(Usuario usuario) throws SQLException {
            String query = "INSERT INTO usuario (nombre) VALUES (?)";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, usuario.getNombre());  // Asignamos el nombre del usuario
                stmt.executeUpdate();                    // Ejecutamos la inserción en la base de datos
            }
        }

        // Método para obtener todos los usuarios de la base de datos
        public List<Usuario> leerUsuarios() throws SQLException {
            List<Usuario> usuarios = new ArrayList<>();
            String query = "SELECT * FROM usuario";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    usuarios.add(new Usuario(id, nombre));  // Añadimos cada usuario a la lista
                }
            }
            return usuarios;  // Retornamos la lista de usuarios
        }

        // Método para actualizar un usuario en la base de datos
        public void actualizarUsuario(Usuario usuario) throws SQLException {
            String query = "UPDATE usuario SET nombre = ? WHERE id = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, usuario.getNombre());  // Actualizamos el nombre del usuario
                stmt.setInt(2, usuario.getId());         // Especificamos el ID del usuario a actualizar
                stmt.executeUpdate();                    // Ejecutamos la actualización
            }
        }

        // Método para eliminar un usuario de la base de datos
        public void eliminarUsuario(int id) throws SQLException {
            String query = "DELETE FROM usuario WHERE id = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setInt(1, id);  // Especificamos el ID del usuario a eliminar
                stmt.executeUpdate();  // Ejecutamos la eliminación
            }
        }
    }


