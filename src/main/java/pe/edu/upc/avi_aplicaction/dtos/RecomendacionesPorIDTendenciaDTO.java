package pe.edu.upc.avi_aplicaction.dtos;

public class RecomendacionesPorIDTendenciaDTO {
    private int id_tendencias;
    private Long total_recomendaciones;

    public int getId_tendencias() {
        return id_tendencias;
    }

    public void setId_tendencias(int id_tendencias) {
        this.id_tendencias = id_tendencias;
    }

    public Long getTotal_recomendaciones() {
        return total_recomendaciones;
    }

    public void setTotal_recomendaciones(Long total_recomendaciones) {
        this.total_recomendaciones = total_recomendaciones;
    }
}
