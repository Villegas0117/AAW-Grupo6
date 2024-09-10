
package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRecomendacionesRepository extends JpaRepository<Recomendaciones,Integer> {

    @Query("SELECT r FROM Recomendaciones r WHERE r.id_Usuario = :idUsuario")
    public List<Recomendaciones> BuscarPorUsuario(@Param("idUsuario") int idUsuario);

    @Query("SELECT r FROM Recomendaciones r WHERE r.id_Tendencia = :idTendencia")
    public List<Recomendaciones> BuscarPorTendencia(@Param("idTendencia") int idTendencia);

    //Suma Total de Recomendaciones por Usuario
    @Query(value = "SELECT id_usuario, COUNT(*) AS total_recomendaciones FROM recomendaciones GROUP BY id_usuario", nativeQuery = true)
    List<String[]> findTotalRecomendacionesPorUsuario();

    // Suma Total de Recomendaciones por Tendencia
    @Query(value = "SELECT id_Tendencia, COUNT(*) AS total_recomendaciones FROM recomendaciones GROUP BY id_Tendencia", nativeQuery = true)
    List<String[]> findTotalRecomendacionesPorTendencia();

    @Query(value = "SELECT COUNT(*) FROM recomendaciones WHERE fecha_modificacion BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    Long findTotalRecomendacionesPorIntervalo(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

}
