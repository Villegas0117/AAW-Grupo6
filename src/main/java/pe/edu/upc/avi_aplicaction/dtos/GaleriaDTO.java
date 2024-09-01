package pe.edu.upc.avi_aplicaction.dtos;


import pe.edu.upc.avi_aplicaction.entities.Users;

public class GaleriaDTO {

    private int id_galeria;

    private String nombre_galeria;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modificacion;

    private Users us;

    public String getNombre_galeria() {
        return nombre_galeria;
    }

    public void setNombre_galeria(String nombre_galeria) {
        this.nombre_galeria = nombre_galeria;
    }

    public int getId_galeria() {
        return id_galeria;
    }

    public void setId_galeria(int id_galeria) {
        this.id_galeria = id_galeria;
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

    public Users getUs() {
        return us;
    }

    public void setUs(Users us) {
        this.us = us;
    }
}
