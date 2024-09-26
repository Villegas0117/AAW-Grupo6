package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "prendas")
public class Prendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prenda;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users id_usuario;//FK

    @Column(name="nombre_prenda",nullable = false,length = 100)
    private String nombre_prenda;

    @Column(name = "tipo_prenda",nullable = false,length = 255)
    private String tipo_prenda;

    @Column(name = "imagen_url",nullable = false)
    private String imagen_url;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fecha_creacion;

    @Column(name = "fecha_modificacion",nullable = false)
    private LocalDate fecha_modificacion;



    public Prendas(int id_prenda, Users id_usuario, String nombre_prenda, String tipo_prenda, String imagen_url, LocalDate fecha_creacion, LocalDate fecha_modificacion) {
        this.id_prenda = id_prenda;
        this.id_usuario = id_usuario;
        this.nombre_prenda = nombre_prenda;
        this.tipo_prenda = tipo_prenda;
        this.imagen_url = imagen_url;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Prendas() {
    }

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
