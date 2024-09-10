package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "recomendaciones")
public class Recomendaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id_Recomendacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users id_Usuario;//FK

    @ManyToOne
    @JoinColumn(name = "id_tendencia")
    private Tendencia id_Tendencia;//FK

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "fecha_Creacion", nullable = false)
    private LocalDate fecha_Creacion;

    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDate fecha_modificacion;


    public Recomendaciones() {
    }

    public Recomendaciones(int id_Recomendacion, Tendencia id_Tendencia, Users id_Usuario, String descripcion, LocalDate fecha_modificacion, LocalDate fecha_Creacion) {
        this.id_Recomendacion = id_Recomendacion;
        this.id_Tendencia = id_Tendencia;
        this.id_Usuario = id_Usuario;
        this.descripcion = descripcion;
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_Creacion = fecha_Creacion;
    }

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
