package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "galerias")
public class Galerias {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idGaleria;

    @Column(name = "nombre_galeria")
    private String nombreGaleria;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users idUsuario;

    //Constructor con asignacion de valores a los atributos


    public Galerias(int idGaleria, Users idUsuario, LocalDate fechaModificacion, LocalDate fechaCreacion, String nombreGaleria) {
        this.idGaleria = idGaleria;
        this.idUsuario = idUsuario;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
        this.nombreGaleria = nombreGaleria;
    }

    public Galerias() {
    }
    //Propiedades


    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreGaleria() {
        return nombreGaleria;
    }

    public void setNombreGaleria(String nombreGaleria) {
        this.nombreGaleria = nombreGaleria;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
