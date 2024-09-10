package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "recomendaciones")
public class Recomendaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id_Recomendacion;

    @Column(name = "id_Usuario",nullable = false)
    private int id_Usuario;

    @Column(name = "id_Tendencia",nullable = false)
    private int id_Tendencia;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "fecha_Creacion", nullable = false)
    private LocalDate fecha_Creacion;

    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDate fecha_modificacion;

    public int getId_Recomendacion() {
        return id_Recomendacion;
    }

    public void setId_Recomendacion(int id_Recomendacion) {
        this.id_Recomendacion = id_Recomendacion;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Tendencia() {
        return id_Tendencia;
    }

    public void setId_Tendencia(int id_Tendencia) {
        this.id_Tendencia = id_Tendencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDate fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDate fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
