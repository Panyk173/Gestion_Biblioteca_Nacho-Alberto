package org.example;
public class Usuario {
        private int id;
        private String nombre;

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

        // el clasico to string
        @Override
        public String toString() {
            return "Usuario [ID=" + id + ", Nombre=" + nombre + "]";
        }
    }


