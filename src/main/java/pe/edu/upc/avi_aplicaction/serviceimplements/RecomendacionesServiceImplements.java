package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;
import pe.edu.upc.avi_aplicaction.repositories.IRecomendacionesRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRecomendacionesService;

import java.util.List;

@Service

public class RecomendacionesServiceImplements implements IRecomendacionesService {
    @Autowired
    private IRecomendacionesRepository rR;

    @Override
    public void insertar_Recomendacion(Recomendaciones recomendaciones) {
        rR.save(recomendaciones);//por medio de la instancia pR se llama el metodo save que guarda nuevas prendas
    }

    @Override
    public List<Recomendaciones> list() {
        return rR.findAll();
    }

    @Override
    public void deleteRecomendacion(int id) {
        rR.deleteById(id);
    }

    @Override
    public Recomendaciones listRecomendacionById(int id) {
        return rR.findById(id).orElse(new Recomendaciones());
    }

    @Override
    public void updateRecomendacion(Recomendaciones recomendaciones) {
        rR.save(recomendaciones);
    }
}
