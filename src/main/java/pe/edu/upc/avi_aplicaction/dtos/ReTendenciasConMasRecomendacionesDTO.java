package pe.edu.upc.avi_aplicaction.dtos;

public class ReTendenciasConMasRecomendacionesDTO {
    private int id_Tendencia;
    private String nombre_tendencia;
    private long total_recomendaciones;

    public int getId_Tendencia() {
        return id_Tendencia;
    }

    public void setId_Tendencia(int id_Tendencia) {
        this.id_Tendencia = id_Tendencia;
    }

    public String getNombre_tendencia() {
        return nombre_tendencia;
    }

    public void setNombre_tendencia(String nombre_tendencia) {
        this.nombre_tendencia = nombre_tendencia;
    }

    public long getTotal_recomendaciones() {
        return total_recomendaciones;
    }

    public void setTotal_recomendaciones(long total_recomendaciones) {
        this.total_recomendaciones = total_recomendaciones;
    }
}
