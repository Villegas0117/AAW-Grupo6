package pe.edu.upc.avi_aplicaction.dtos;

import pe.edu.upc.avi_aplicaction.entities.Tendencia;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.time.LocalDate;

public class RecomendacionesDTO {
    private int id_Recomendacion;
    private Users id_Usuario;//FK
    private Tendencia id_Tendencia;//FK
    private String descripcion  ;
    private LocalDate fecha_creacion;
    private LocalDate fecha_modificacion;

    public int getId_Recomendacion() {
        return id_Recomendacion;
    }

    public void setId_Recomendacion(int id_Recomendacion) {
        this.id_Recomendacion = id_Recomendacion;
    }

    public Users getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Users id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Tendencia getId_Tendencia() {
        return id_Tendencia;
    }

    public void setId_Tendencia(Tendencia id_Tendencia) {
        this.id_Tendencia = id_Tendencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDate fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
