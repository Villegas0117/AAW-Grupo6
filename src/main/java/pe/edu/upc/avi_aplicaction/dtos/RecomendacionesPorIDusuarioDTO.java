package pe.edu.upc.avi_aplicaction.dtos;

public class RecomendacionesPorIDusuarioDTO {
    private int id_usuario;
    private Long total_recomendaciones;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getTotal_recomendaciones() {
        return total_recomendaciones;
    }

    public void setTotal_recomendaciones(Long total_recomendaciones) {
        this.total_recomendaciones = total_recomendaciones;
    }
}
