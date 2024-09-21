package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
import pe.edu.upc.avi_aplicaction.repositories.IGaleriasRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IGaleriasService;


import java.util.List;

@Service
public class GaleriasServiceImplements implements IGaleriasService {
    @Autowired
    private IGaleriasRepository galeriasRepository;

    @Override
    public void insertar(Galerias galerias) {
        galeriasRepository.save(galerias);
    }

    @Override
    public List<Galerias> list() {
        return galeriasRepository.findAll();
    }

    @Override
    public void deleteGaleria(int id) {
        galeriasRepository.deleteById(id);
    }

    @Override
    public Galerias listGaleriaById(int id) {
        return galeriasRepository.findById(id).orElse(new Galerias());
    }

    @Override
    public void updateGalerias(Galerias Galerias) {
        galeriasRepository.save(Galerias);
    }

    @Override
    public List<String[]> GaleriaMasReciente() {
        return galeriasRepository.GaleriaMasReciente();
    }

    @Override
    public List<String[]> GaleriaPorUsuario() {
        return galeriasRepository.GaleriaPorUsuario();
    }

}
