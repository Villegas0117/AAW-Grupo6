package pe.edu.upc.avi_aplicaction.dtos;

public class TendenciaDTO {
    private int idTendencia;
    private String nombre;
    private String descripcion;
    private String categoria;
    private int popularidad;

    public int getIdTendencia() {
        return idTendencia;
    }

    public void setIdTendencia(int idTendencia) {
        this.idTendencia = idTendencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }
}
