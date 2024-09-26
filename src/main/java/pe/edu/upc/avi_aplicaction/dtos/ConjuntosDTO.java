package pe.edu.upc.avi_aplicaction.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.time.LocalDate;

public class ConjuntosDTO {
    private int id_Conjunto;

    private Users id_Usuario;//FK

    private String nombre_Conjunto;

    private Galerias id_Galeria;//FK

    private LocalDate fecha_Creacion;

    private LocalDate fecha_Modificacion;

    public LocalDate getFecha_Modificacion() {
        return fecha_Modificacion;
    }

    public void setFecha_Modificacion(LocalDate fecha_Modificacion) {
        this.fecha_Modificacion = fecha_Modificacion;
    }

    public LocalDate getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDate fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Galerias getId_Galeria() {
        return id_Galeria;
    }

    public void setId_Galeria(Galerias id_Galeria) {
        this.id_Galeria = id_Galeria;
    }

    public String getNombre_Conjunto() {
        return nombre_Conjunto;
    }

    public void setNombre_Conjunto(String nombre_Conjunto) {
        this.nombre_Conjunto = nombre_Conjunto;
    }

    public Users getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Users id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Conjunto() {
        return id_Conjunto;
    }

    public void setId_Conjunto(int id_Conjunto) {
        this.id_Conjunto = id_Conjunto;
    }
}
