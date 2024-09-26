package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.entities.Users;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPrendasRepository extends JpaRepository<Prendas, Integer > {

    //BUscar prenda por tipo de prenda
    @Query("SELECT p FROM Prendas p WHERE p.tipo_prenda LIKE %:tipo_prenda%")
    public List<Prendas> buscarPorTipoPrenda(@Param("tipo_prenda") String tipo_prenda);

    //Buscar por fecha

    @Query("SELECT p FROM Prendas p WHERE p.fecha_modificacion = :fecha")
    public List<Prendas> listarPorFecha(@Param("fecha") LocalDate fecha);


}
