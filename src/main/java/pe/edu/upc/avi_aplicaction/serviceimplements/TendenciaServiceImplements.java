package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Tendencia;
import pe.edu.upc.avi_aplicaction.repositories.ITendenciaRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.ITendenciasService;

import java.util.List;

@Service
public class TendenciaServiceImplements implements ITendenciasService {

    @Autowired
    private ITendenciaRepository tRepository;

    @Override
    public List<Tendencia> list() {
        return tRepository.findAll();
    }

    @Override
    public void insert(Tendencia tendencia) {
        tRepository.save(tendencia);
    }

    @Override
    public Tendencia listId(Integer id) {
        return tRepository.findById(id).orElse(new Tendencia());
    }

    @Override
    public void update(Tendencia tendencia) {
        tRepository.save(tendencia);
    }

    @Override
    public void delete(Integer id) {
        tRepository.deleteById(id);
    }

    @Override
    public List<Tendencia> buscarPorCategoria(String categoria) {
        return tRepository.buscarPorCategoria(categoria);
    }

    @Override
    public List<Tendencia> buscarPorPopularidad(int popularidad) {
        return tRepository.buscarPorPopularidad();
    }

}
