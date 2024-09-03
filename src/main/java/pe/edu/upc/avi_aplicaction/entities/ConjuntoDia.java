package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conjunto_dia")
public class ConjuntoDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "id_conjunto")
    private int id_conjunto;

    @Column(name = "diadesemana")
    private LocalDateTime diaDeSemana;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.id_usuario = idUsuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdConjunto() {
        return id_conjunto;
    }

    public void setIdConjunto(int idConjunto) {
        this.id_conjunto = idConjunto;
    }

    public LocalDateTime getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(LocalDateTime diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }
}
