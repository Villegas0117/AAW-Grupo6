// Repositorio Tendencia
package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Tendencia;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

@Repository
public interface ITendenciaRepository extends JpaRepository<Tendencia, Integer> {


    @Query("SELECT d FROM Tendencia d WHERE d.categoria LIKE %:categoria%")
    public List<Tendencia> buscarPorCategoria(@Param("categoria") String categoria);

    @Query("SELECT t FROM Tendencia t ORDER BY t.popularidad DESC")
    List<Tendencia> buscarPorPopularidad();
}
