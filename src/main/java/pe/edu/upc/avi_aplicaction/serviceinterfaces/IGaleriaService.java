package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.Galeria;

import java.util.List;

public interface IGaleriaService {
    public List<Galeria> list();

    void inert(Galeria v);
    public Galeria listId(int id);
    public void update(Galeria v);
    public void delete(int id);
    public List<Galeria> buscarnombre(String nombre);
}
