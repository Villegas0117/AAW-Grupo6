
package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

@Repository
public interface IRecomendacionesRepository extends JpaRepository<Recomendaciones,Integer> {


    @Query("SELECT r FROM Recomendaciones r WHERE r.id_Usuario = :idUsuario")
    public List<Recomendaciones> BuscarPorUsuario(@Param("idUsuario") int idUsuario);

    @Query("SELECT r FROM Recomendaciones r WHERE r.id_Tendencia = :idTendencia")
    public List<Recomendaciones> BuscarPorTendencia(@Param("idTendencia") int idTendencia);


}
