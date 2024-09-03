package pe.edu.upc.avi_aplicaction.dtos;

import java.time.LocalDateTime;

public class ConjuntoDiaDTO {
    private int id;
    private int id_usuario; // FK
    private LocalDateTime fecha_creacion;
    private int id_conjunto; // FK
    private LocalDateTime diadesemana;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_conjunto() {
        return id_conjunto;
    }

    public void setId_conjunto(int id_conjunto) {
        this.id_conjunto = id_conjunto;
    }

    public LocalDateTime getDiadesemana() {
        return diadesemana;
    }

    public void setDiadesemana(LocalDateTime diadesemana) {
        this.diadesemana = diadesemana;
    }
}
