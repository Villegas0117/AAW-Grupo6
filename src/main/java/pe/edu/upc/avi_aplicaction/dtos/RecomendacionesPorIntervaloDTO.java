package pe.edu.upc.avi_aplicaction.dtos;

import java.time.LocalDate;

public class RecomendacionesPorIntervaloDTO {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long totalRecomendaciones;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getTotalRecomendaciones() {
        return totalRecomendaciones;
    }

    public void setTotalRecomendaciones(Long totalRecomendaciones) {
        this.totalRecomendaciones = totalRecomendaciones;
    }
}
