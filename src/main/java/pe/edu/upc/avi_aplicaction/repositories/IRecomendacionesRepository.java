
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

    @Query("SELECT r FROM Recomendaciones r WHERE r.id_Usuario = :id_usuario")
    public List<Recomendaciones> BuscarPorUsuario(@Param("id_usuario") int id_usuario);

    @Query("SELECT r FROM Recomendaciones r WHERE r.id_Tendencia.idTendencia = :idTendencia")
    public List<Recomendaciones> BuscarPorTendencia(@Param("idTendencia") int idTendencia);

    //Suma Total de Recomendaciones por Usuario
    @Query(value = "SELECT id, COUNT(*) AS total_recomendaciones FROM recomendaciones GROUP BY id", nativeQuery = true)
    List<String[]> findTotalRecomendacionesPorUsuario();

    // Suma Total de Recomendaciones por Tendencia
    @Query(value = "SELECT id_Tendencia, COUNT(*) AS total_recomendaciones FROM recomendaciones GROUP BY id_Tendencia", nativeQuery = true)
    List<String[]> findTotalRecomendacionesPorTendencia();

    @Query(value = "SELECT COUNT(*) FROM recomendaciones WHERE fecha_modificacion BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    Long findTotalRecomendacionesPorIntervalo(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

    @Query(value = "SELECT u.id_usuario, u.username, COUNT(r.id_Recomendacion) AS total_recomendaciones " +
            "FROM recomendaciones r " +
            "JOIN usuarios u ON r.id_usuario = u.id_usuario " +
            "GROUP BY u.id_usuario, u.username " +
            "ORDER BY total_recomendaciones DESC " +
            "LIMIT :topN", nativeQuery = true)
    List<String[]> findTopNUsuariosConMasRecomendaciones(@Param("topN") int topN);

    @Query(value = "SELECT t.id_Tendencia, t.nombre, COUNT(r.id_Recomendacion) AS total_recomendaciones " +
            "FROM recomendaciones r " +
            "JOIN tendencias t ON r.id_Tendencia = t.id_Tendencia " +
            "GROUP BY t.id_Tendencia, t.nombre " +
            "ORDER BY total_recomendaciones DESC " +
            "LIMIT :topN", nativeQuery = true)
    List<String[]> findTopNTendenciasConMasRecomendaciones(@Param("topN") int topN);

}
