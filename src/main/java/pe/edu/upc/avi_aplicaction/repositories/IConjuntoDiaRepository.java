package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoSemanal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IConjuntoDiaRepository extends JpaRepository<ConjuntoSemanal, Integer> {

    // Buscar por id_usuario
    @Query("SELECT cd FROM ConjuntoSemanal cd WHERE cd.id_usuario = :id_usuario")
    List<ConjuntoSemanal> buscarPorUsuario(@Param("id_usuario") int id_usuario);

    // Buscar por id_conjunto
    @Query("SELECT cd FROM ConjuntoSemanal cd WHERE cd.id_Conjunto = :id_conjunto")
    List<ConjuntoSemanal> buscarporIdConjunto(@Param("id_conjunto") int id_conjunto);

    // Buscar registros entre dos fechas
    @Query("SELECT cd FROM ConjuntoSemanal cd WHERE cd.fechaCreacion BETWEEN :startDate AND :endDate")
    List<ConjuntoSemanal> findByFechaCreacionBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // Query de valor: Obtener el registro mas reciente por usuario
    @Query("SELECT cd FROM ConjuntoSemanal cd WHERE cd.id_usuario = :id_usuario ORDER BY cd.fechaCreacion DESC")
    ConjuntoSemanal obtenerRegistroMasRecientePorUsuario(@Param("id_usuario") int id_usuario);

    //Consulta para obtener la cantidad de conjuntos creados por cada usuario ordenados por el total en orden descendente:
    @Query(value = " SELECT u.username AS usuario, COUNT(c.id) AS total_conjuntos " +
            " FROM conjunto_dia c " +
            " INNER JOIN usuarios u ON c.id_usuario = u.id " +
            " GROUP BY u.username " +
            " ORDER BY total_conjuntos DESC;", nativeQuery = true)
    public List<String[]> ConjuntosPorUsuario();

    //Consulta para contar los conjuntos creados en cada día de la semana, ordenados por el día de la semana:

    @Query(value = " SELECT co.nombre_Conjunto AS nombreConjunto, COUNT(cd.id) AS totalDias " +
            " FROM conjunto_dia cd " +
            " INNER JOIN conjuntos co ON cd.id_Conjunto = co.id_Conjunto " +
            " GROUP BY co.nombre_Conjunto " +
            " ORDER BY totalDias DESC;", nativeQuery = true)
    public List<String[]> ConjuntosPorDiaDeSemana();


}
