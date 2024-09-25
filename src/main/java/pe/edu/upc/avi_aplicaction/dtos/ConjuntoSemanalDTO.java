package pe.edu.upc.avi_aplicaction.dtos;

import jakarta.persistence.*;
import pe.edu.upc.avi_aplicaction.entities.Conjuntos;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConjuntoSemanalDTO {

    private int id;

    private Users id_usuario;//FK

    private LocalDate fechaCreacion;


    private Conjuntos id_conjunto;//FK


    private LocalDate diaDeSemana;

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
