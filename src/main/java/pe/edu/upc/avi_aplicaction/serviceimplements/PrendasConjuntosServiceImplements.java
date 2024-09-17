package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.PrendasConjuntos;
import pe.edu.upc.avi_aplicaction.repositories.IGaleriasRepository;
import pe.edu.upc.avi_aplicaction.repositories.IPrendasConjuntosRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IPrendasConjuntosService;

import java.util.List;

@Service
public class PrendasConjuntosServiceImplements implements IPrendasConjuntosService {
    @Autowired
    private IPrendasConjuntosRepository prendasConjuntosRepository;

    @Override
    public void insert(PrendasConjuntos prendasConjuntos) {
        prendasConjuntosRepository.save(prendasConjuntos);
    }

    @Override
    public List<PrendasConjuntos> list() {
        return prendasConjuntosRepository.findAll();
    }

    @Override
    public void deletePrendasConjuntos(int id) {
        prendasConjuntosRepository.deleteById(id);
    }

    @Override
    public PrendasConjuntos listById(int id) {
        return prendasConjuntosRepository.findById(id).orElse(new PrendasConjuntos());
    }

    @Override
    public void updatePrendasConjuntos(PrendasConjuntos prendasConjuntos) {
        prendasConjuntosRepository.save(prendasConjuntos);
    }
}
