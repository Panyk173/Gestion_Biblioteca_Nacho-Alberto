package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestionLibro {

    // DAO de libro para realizar las operaciones CRUD
    private LibroDAO libroDAO;

    // Constructor que recibe la conexión
    public GestionLibro(Connection connection) {
        this.libroDAO = new LibroDAO(connection);
    }

    // Metodo para agregar un libro
    public void agregarLibro(Libro libro) {
        try {
            libroDAO.agregarLibro(libro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para obtener un libro por su ID
    public Libro obtenerLibroPorId(int id) {
        try {
            return libroDAO.obtenerLibroPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metodo para actualizar un libro
    public void actualizarLibro(Libro libro) {
        try {
            libroDAO.actualizarLibro(libro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar un libro por su ID
    public void eliminarLibro(int id) {
        try {
            libroDAO.eliminarLibro(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para listar todos los libros
    public List<Libro> listarLibros() {
        try {
            return libroDAO.listarLibros();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
