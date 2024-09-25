package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "conjunto_dia")
public class ConjuntoSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users id_usuario;//FK

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_conjunto")
    private Conjuntos id_conjunto;//FK

    @Column(name = "diadesemana")
    private LocalDate diaDeSemana;

    public ConjuntoSemanal() {
    }

    public ConjuntoSemanal(int id, Users id_usuario, LocalDate fechaCreacion, Conjuntos id_conjunto, LocalDate diaDeSemana) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.fechaCreacion = fechaCreacion;
        this.id_conjunto = id_conjunto;
        this.diaDeSemana = diaDeSemana;
    }
    // Getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Users id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Conjuntos getId_conjunto() {
        return id_conjunto;
    }

    public void setId_conjunto(Conjuntos id_conjunto) {
        this.id_conjunto = id_conjunto;
    }

    public LocalDate getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(LocalDate diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }
}
