package pe.edu.upc.avi_aplicaction.dtos;

public class ReUsuariosConMasRecomendacionesDTO {
    private int id_usuario;
    private String nombre_usuario;
    private Long total_recomendaciones;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public Long getTotal_recomendaciones() {
        return total_recomendaciones;
    }

    public void setTotal_recomendaciones(Long total_recomendaciones) {
        this.total_recomendaciones = total_recomendaciones;
    }
}
