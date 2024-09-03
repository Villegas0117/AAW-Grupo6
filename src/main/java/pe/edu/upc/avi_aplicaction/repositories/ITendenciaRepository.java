// Repositorio Tendencia
package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Tendencia;

import java.util.List;

@Repository
public interface ITendenciaRepository extends JpaRepository<Tendencia, Integer> {

    @Query("SELECT t FROM Tendencia t WHERE t.categoria = :categoria")
    List<Tendencia> buscarPorCategoria(@Param("categoria") String categoria);

    @Query("SELECT t FROM Tendencia t WHERE t.popularidad > :popularidad")
    List<Tendencia> buscarPorPopularidad(@Param("popularidad") int popularidad);
}
