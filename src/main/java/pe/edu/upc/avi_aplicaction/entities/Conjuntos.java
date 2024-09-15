package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "conjuntos")
public class Conjuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Conjunto;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users id_Usuario;//FK
    @Column(name = "nombre_Conjunto", nullable = false, length = 100)
    private String nombre_Conjunto;
    @ManyToOne
    @JoinColumn(name = "id_galeria")
    private Galerias id_Galeria;//FK
    @Column(name = "fecha_Creacion", nullable = false)
    private LocalDate fecha_Creacion;
    @Column(name = "fecha_Modificacion", nullable = false)
    private LocalDate fecha_Modificacion;

    public Conjuntos() {
    }

    public Conjuntos(int id_Conjunto, Users id_Usuario, String nombre_Conjunto, Galerias id_Galeria, LocalDate fecha_Creacion, LocalDate fecha_Modificacion) {
        this.id_Conjunto = id_Conjunto;
        this.id_Usuario = id_Usuario;
        this.nombre_Conjunto = nombre_Conjunto;
        this.id_Galeria = id_Galeria;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Modificacion = fecha_Modificacion;
    }

    public int getId_Conjunto() {
        return id_Conjunto;
    }

    public void setId_Conjunto(int id_Conjunto) {
        this.id_Conjunto = id_Conjunto;
    }

    public Users getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Users id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre_Conjunto() {
        return nombre_Conjunto;
    }

    public void setNombre_Conjunto(String nombre_Conjunto) {
        this.nombre_Conjunto = nombre_Conjunto;
    }

    public Galerias getId_Galeria() {
        return id_Galeria;
    }

    public void setId_Galeria(Galerias id_Galeria) {
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

