package org.example;
public class Usuario {
        private int id;          // Identificador único del usuario
        private String nombre;   // Nombre del usuario

        // Constructor básico
        public Usuario(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        // Getters y setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        // Método para mostrar información del usuario
        @Override
        public String toString() {
            return "Usuario [ID=" + id + ", Nombre=" + nombre + "]";
        }
    }


