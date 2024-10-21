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

    // metodo de nuevo usuario
    public void crearUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre) VALUES (?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.executeUpdate();
        }
    }

    //obtener usuarios
    public List<Usuario> leerUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                // Añadimos cada usuario a la lista
                usuarios.add(new Usuario(id, nombre));
            }
        }
        return usuarios;
    }

    // Metodo para actualizar
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getId());
            stmt.executeUpdate();
        }
    }

    // elimnar usuarioss
    public void eliminarUsuario(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // coger por id
    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);  // Pasamos el ID como parámetro
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    return new Usuario(id, nombre);
                }
            }
        }

        //si falla que nos de null
        return null;
    }
}
