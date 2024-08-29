package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Conjuntos;
import pe.edu.upc.avi_aplicaction.repositories.IConjuntosRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosService;

import java.util.List;


@Service
public class ConjuntosServiceImplements implements IConjuntosService {
    @Autowired
    private IConjuntosRepository cR;


    @Override
    public List<Conjuntos> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Conjuntos conjunto) {
        cR.save(conjunto);
    }

    @Override
    public Conjuntos listId(int id_Conjuntos) {
        return cR.findById(id_Conjuntos).orElse(new Conjuntos());
    }

    @Override
    public void update(Conjuntos conjuntos) {
        cR.save(conjuntos);
    }

    @Override
    public List<Conjuntos> buscar(String nombre_Conjunto) {
        return cR.buscarPorNombre(nombre_Conjunto);
    }

    @Override
    public void delete(int id_Conjuntos) {

    }

    @Override
    public List<Conjuntos> buscarUltimosModificados() {
        return cR.buscarUltimosModificados();
    }

}
