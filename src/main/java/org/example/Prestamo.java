package org.example;
import java.sql.Date;
public class Prestamo {
        private int id;
        private Date fechaInicio;
        private Date fechaFin;
        private Usuario usuario;
        private Libro libro;

        // Constructor clasico
        public Prestamo(int id, Date fechaInicio, Date fechaFin, Usuario usuario, Libro libro) {
            this.id = id;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.usuario = usuario;
            this.libro = libro;
        }

        // Getters y setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getFechaInicio() {
            return fechaInicio;
        }

        public void setFechaInicio(Date fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public Date getFechaFin() {
            return fechaFin;
        }

        public void setFechaFin(Date fechaFin) {
            this.fechaFin = fechaFin;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Libro getLibro() {
            return libro;
        }

        public void setLibro(Libro libro) {
            this.libro = libro;
        }

        // el tostring clasico
        @Override
        public String toString() {
            return "Prestamo [ID=" + id + ", Fecha de Inicio=" + fechaInicio + ", Fecha de Fin=" + fechaFin +
                    ", Usuario=" + usuario.getNombre() + ", Libro=" + libro.getTitulo() + "]";
        }
    }


