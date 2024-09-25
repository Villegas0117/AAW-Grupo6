package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;
import pe.edu.upc.avi_aplicaction.repositories.IRecomendacionesRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRecomendacionesService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecomendacionesServiceImplements implements IRecomendacionesService {
    @Autowired
    private IRecomendacionesRepository rR;

    @Override
    public void insertar_Recomendacion(Recomendaciones recomendaciones) {
        rR.save(recomendaciones);//por medio de la instancia rR se llama el metodo save que guarda nuevas prendas
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

    @Override
    public List<Recomendaciones> getRecomendacionesByUserId(int idUsuario) {
        return rR.BuscarPorUsuario(idUsuario);
    }

    @Override
    public List<Recomendaciones> getRecomendacionesByTrendId(int idTendencia) {
        return rR.BuscarPorTendencia(idTendencia);
    }

    @Override
    public Long obtenerTotalRecomendacionesPorIntervalo(LocalDate fechaInicio, LocalDate fechaFin) {
        return rR.findTotalRecomendacionesPorIntervalo(fechaInicio, fechaFin);
    }

    @Override
    public List<String[]> obtenerTopNUsuariosConMasRecomendaciones(int topN) {
        return rR.findTopNUsuariosConMasRecomendaciones(topN);
    }

    @Override
    public List<String[]> obtenerTopTendenciasConMasRecomendaciones(int topN) {
        return rR.findTopNTendenciasConMasRecomendaciones(topN);
    }


}
