package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.Conjuntos;

import java.util.List;

public interface IConjuntosService {
    public List<Conjuntos> list();

    public void insert(Conjuntos conjuntos);
    public Conjuntos listId(int id_Conjuntos);
    public void update(Conjuntos conjuntos);
    public List<Conjuntos> buscar(String nombre_Conjunto);
    public void delete(int id_Conjuntos);

    List<Conjuntos> buscarUltimosModificados();
}
