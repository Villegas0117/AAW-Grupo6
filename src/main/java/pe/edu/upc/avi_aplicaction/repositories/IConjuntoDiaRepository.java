package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoSemanal;

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



}
