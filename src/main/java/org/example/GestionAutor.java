package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestionAutor {

    // DAO de autor para realizar las operaciones CRUD
    private AutorDAO autorDAO;

    // Constructor que recibe la conexión
    public GestionAutor(Connection connection) {
        this.autorDAO = new AutorDAO(connection);
    }

    // Metodo para agregar un autor
    public void agregarAutor(Autor autor) {
        try {
            autorDAO.agregarAutor(autor); // Llamamos al DAO para agregar el autor
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener un autor por su ID
    public Autor obtenerAutorPorId(int id) {
        try {
            return autorDAO.obtenerAutorPorId(id); // Obtenemos el autor desde el DAO
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metodo para actualizar un autor
    public void actualizarAutor(Autor autor) {
        try {
            autorDAO.actualizarAutor(autor); // Actualizamos el autor a través del DAO
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar un autor por su ID
    public void eliminarAutor(int id) {
        try {
            autorDAO.eliminarAutor(id); // Llamamos al DAO para eliminar el autor
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para listar todos los autores
    public List<Autor> listarAutores() {
        try {
            return autorDAO.listarAutores(); // Obtenemos la lista de autores desde el DAO
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}