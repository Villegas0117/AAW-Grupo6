package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoDia;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IConjuntoDiaRepository extends JpaRepository<ConjuntoDia, Integer> {

    // Buscar por id_usuario
    @Query("SELECT cd FROM ConjuntoDia cd WHERE cd.id_usuario = :id_usuario")
    List<ConjuntoDia> buscarPorUsuario(@Param("id_usuario") int id_usuario);

    // Buscar por id_conjunto
    @Query("SELECT cd FROM ConjuntoDia cd WHERE cd.id_conjunto = :id_conjunto")
    List<ConjuntoDia> buscarporIdConjunto(@Param("id_conjunto") int id_conjunto);

    // Buscar registros entre dos fechas
    @Query("SELECT cd FROM ConjuntoDia cd WHERE cd.fechaCreacion BETWEEN :startDate AND :endDate")
    List<ConjuntoDia> buscarporFecha(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT cd FROM ConjuntoDia cd WHERE cd.id_usuario = :id_usuario ORDER BY cd.fechaCreacion DESC LIMIT 1")
    ConjuntoDia obtenerRegistroMasRecientePorUsuario(@Param("id_usuario") int id_usuario);


}
