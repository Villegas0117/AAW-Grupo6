package pe.edu.upc.avi_aplicaction.dtos;

public class TendenciaDTO {
    private int id_tendencia;
    private String nombre;
    private String descripcion;
    private String categoria;
    private int popularidad;

    public int getId_tendencia() {
        return id_tendencia;
    }

    public void setId_tendencia(int id_tendencia) {
        this.id_tendencia = id_tendencia;
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
