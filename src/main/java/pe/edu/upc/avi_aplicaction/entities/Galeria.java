package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Galeria")
public class Galeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_galeria;

    @Column(name = "nombre_galeria", nullable=false, length = 20)
    private String nombre_galeria;

    @Column(name = "fecha_creacion", nullable=false)
    private LocalDate fecha_creacion;

    @Column(name = "fecha_modificacion", nullable=false)
    private LocalDate fecha_modificacion;

    @JoinColumn(name = "id_usuario")
    private Users us;
    public Galeria() {

    }

    public Galeria(LocalDate fecha_modificacion, Users us, LocalDate fecha_creacion, String nombre_galeria, int id_galeria) {
        this.fecha_modificacion = fecha_modificacion;
        this.us = us;
        this.fecha_creacion = fecha_creacion;
        this.nombre_galeria = nombre_galeria;
        this.id_galeria = id_galeria;
    }

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

    public Users getUs() {
        return us;
    }

    public void setUs(Users us) {
        this.us = us;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDate fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
