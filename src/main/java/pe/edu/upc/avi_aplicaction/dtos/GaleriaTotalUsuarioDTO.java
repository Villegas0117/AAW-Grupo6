package pe.edu.upc.avi_aplicaction.dtos;

public class GaleriaTotalUsuarioDTO {
    private String nombre_usuario;
    private int total_galerias;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getTotal_galerias() {
        return total_galerias;
    }

    public void setTotal_galerias(int total_galerias) {
        this.total_galerias = total_galerias;
    }
}
