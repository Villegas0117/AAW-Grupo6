package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;

import java.time.LocalDate;
import java.util.List;

public interface IRecomendacionesService {
    //crear una recomendacion
    public void insertar_Recomendacion(Recomendaciones recomendaciones);

    //Listar la tabla recomendacion
    public List<Recomendaciones> list();

    //eliminar una recomendacion por ID
    public void deleteRecomendacion(int id);

    //listar una recomendacion por ID
    public Recomendaciones listRecomendacionById(int id);

    //actualizar una recomendacion
    public void updateRecomendacion(Recomendaciones recomendaciones);

    public List<Recomendaciones> getRecomendacionesByUserId(int id_usuario);

    public List<Recomendaciones> getRecomendacionesByTrendId(int idTendencia);

    public Long obtenerTotalRecomendacionesPorIntervalo(LocalDate fechaInicio, LocalDate fechaFin);

    public List<String[]> obtenerTopNUsuariosConMasRecomendaciones(int topN);

    public List<String[]> obtenerTopTendenciasConMasRecomendaciones(int topN);

}
