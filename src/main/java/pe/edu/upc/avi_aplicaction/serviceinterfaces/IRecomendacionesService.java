package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;

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

}
