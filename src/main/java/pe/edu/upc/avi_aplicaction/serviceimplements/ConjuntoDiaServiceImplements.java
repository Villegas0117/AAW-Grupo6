package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoDia;
import pe.edu.upc.avi_aplicaction.repositories.IConjuntoDiaRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosDiaService;

import java.util.List;

@Service
public class ConjuntoDiaServiceImplements implements IConjuntosDiaService {

    @Autowired
    private IConjuntoDiaRepository cDRepository;

    @Override
    public List<ConjuntoDia> list() {
        return cDRepository.findAll();
    }

    @Override
    public void insert(ConjuntoDia conjuntoDia) {
        cDRepository.save(conjuntoDia);
    }

    @Override
    public ConjuntoDia listId(Integer id) {
        return cDRepository.findById(id).orElse(new ConjuntoDia());
    }

    @Override
    public void update(ConjuntoDia conjuntoDia) {
        cDRepository.save(conjuntoDia);
    }

    @Override
    public void delete(Integer id) {
        cDRepository.deleteById(id);
    }


    @Override
    public List<ConjuntoDia> buscarPorUsuario(int idUsuario) {
        return cDRepository.buscarPorUsuario(idUsuario);
    }

    @Override
    public List<ConjuntoDia> buscarporIdConjunto(int idUsuario) {
        return cDRepository.buscarporIdConjunto(idUsuario);
    }
    @Override
    public ConjuntoDia obtenerRegistroMasRecientePorUsuario(int id_usuario) {
        return cDRepository.obtenerRegistroMasRecientePorUsuario(id_usuario);
    }

}