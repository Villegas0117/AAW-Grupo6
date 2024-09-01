package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.arquitectura_av1.entities.Galeria;


@Repository
public interface IGaleriaRepository extends JpaRepository<Galeria, Integer> {
    @Query("select ga from Galeria ga where ga.nombre_galeria like %:nombre_galeria")
    public List<Galeria> buscargaleria(@Param("nombre_galeria") String nombre_galeria);
}
