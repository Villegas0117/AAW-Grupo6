package pe.edu.upc.avi_aplicaction.serviceinterfaces;


import pe.edu.upc.avi_aplicaction.entities.Tendencia;

import java.util.List;

public interface ITendenciasService {
    public List<Tendencia> list();

    public void insert(Tendencia tendencia);
    public Tendencia listId(Integer id);
    public void update(Tendencia tendencia);
    public void delete(Integer id);

    List<Tendencia> buscarPorCategoria(String categoria);

    List<Tendencia> buscarPorPopularidad(int popularidad);
}
