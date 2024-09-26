package pe.edu.upc.avi_aplicaction.dtos;

import jakarta.persistence.*;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.time.LocalDate;

public class PrendasDTO {

    private int id_prenda;

    private Users id_usuario;//FK

    private String nombre_prenda;

    private String tipo_prenda;

    private String imagen_url;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modificacion;

    public int getId_prenda() {
        return id_prenda;
    }

    public void setId_prenda(int id_prenda) {
        this.id_prenda = id_prenda;
    }

    public Users getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Users id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_prenda() {
        return nombre_prenda;
    }

    public void setNombre_prenda(String nombre_prenda) {
        this.nombre_prenda = nombre_prenda;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
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
