package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Prendas;

import java.util.List;

@Repository
public interface IPrendasRepository extends JpaRepository<Prendas, Integer> {

    @Query("SELECT p FROM Prendas p WHERE p.tipo_prenda = :tipo_prenda")
    List<Prendas> buscarPorTipoPrenda(@Param("tipo_prenda") String tipo_prenda);


    //BUSCAR Prenda por temporada
    @Query("SELECT p FROM Prendas p WHERE p.temporada= :tipo_prenda")
    List<Prendas> buscarPorTemporada(@Param("temporada") String tipo_prenda);

}
