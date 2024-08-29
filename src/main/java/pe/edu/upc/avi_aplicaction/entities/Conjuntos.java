package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "conjuntos")
public class Conjuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Conjunto;
    @Column(name = "id_Usuario", nullable = false)
    private int id_Usuario;//FK
    @Column(name = "nombre_Conjunto", nullable = false, length = 100)
    private String nombre_Conjunto;
    @Column(name = "id_Galeria", nullable = false)
    private int id_Galeria;//FK
    @Column(name = "fecha_Creacion", nullable = false)
    private LocalDate fecha_Creacion;
    @Column(name = "fecha_Modificacion", nullable = false)
    private LocalDate fecha_Modificacion;

    public int getId_Conjunto() {
        return id_Conjunto;
    }

    public void setId_Conjunto(int id_Conjunto) {
        this.id_Conjunto = id_Conjunto;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre_Conjunto() {
        return nombre_Conjunto;
    }

    public void setNombre_Conjunto(String nombre_Conjunto) {
        this.nombre_Conjunto = nombre_Conjunto;
    }

    public int getId_Galeria() {
        return id_Galeria;
    }

    public void setId_Galeria(int id_Galeria) {
        this.id_Galeria = id_Galeria;
    }

    public LocalDate getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDate fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public LocalDate getFecha_Modificacion() {
        return fecha_Modificacion;
    }

    public void setFecha_Modificacion(LocalDate fecha_Modificacion) {
        this.fecha_Modificacion = fecha_Modificacion;
    }
}
