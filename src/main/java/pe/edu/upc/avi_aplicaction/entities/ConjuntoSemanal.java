package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "conjunto_dia")
public class ConjuntoSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_Conjunto")
    private Conjuntos id_Conjunto;//FK

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Users id_usuario;//FK

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;


    @Column(name = "diadesemana")
    private LocalDate diaDeSemana;

    public ConjuntoSemanal() {
    }

    public ConjuntoSemanal(int id, Users id_usuario, LocalDate fechaCreacion, Conjuntos id_conjunto, LocalDate diaDeSemana) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.fechaCreacion = fechaCreacion;
        this.id_Conjunto = id_conjunto;
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

    public Conjuntos getId_Conjunto() {
        return id_Conjunto;
    }

    public void setId_Conjunto(Conjuntos id_Conjunto) {
        this.id_Conjunto = id_Conjunto;
    }

    public LocalDate getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(LocalDate diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }
}
