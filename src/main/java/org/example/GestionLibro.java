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
            libroDAO.agregarLibro(libro); // Llamamos al DAO para agregar el libro
        } catch (SQLException e) {
            e.printStackTrace(); // Mostramos el error en caso de fallo
        }
    }

    // Metodo para obtener un libro por su ID
    public Libro obtenerLibroPorId(int id) {
        try {
            return libroDAO.obtenerLibroPorId(id); // Obtenemos el libro desde el DAO
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Si hay error, devolvemos null
        }
    }

    // Metodo para actualizar un libro
    public void actualizarLibro(Libro libro) {
        try {
            libroDAO.actualizarLibro(libro); // Actualizamos el libro a través del DAO
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar un libro por su ID
    public void eliminarLibro(int id) {
        try {
            libroDAO.eliminarLibro(id); // Llamamos al DAO para eliminar el libro
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para listar todos los libros
    public List<Libro> listarLibros() {
        try {
            return libroDAO.listarLibros(); // Obtenemos la lista de libros desde el DAO
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
