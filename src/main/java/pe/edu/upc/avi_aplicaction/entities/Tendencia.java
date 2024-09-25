package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tendencias")
public class Tendencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTendencia;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "popularidad")
    private int popularidad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;


    // Getters y setters
    public int getIdTendencia() {
        return idTendencia;
    }

    public void setIdTendencia(int idTendencia) {
        this.idTendencia = idTendencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
