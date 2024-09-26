package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Conjuntos;

import java.util.List;

@Repository
public interface IConjuntosRepository extends JpaRepository<Conjuntos, Integer>{

    @Query("SELECT c from Conjuntos c WHERE c.nombre_Conjunto LIKE %:nombre_Conjunto%")
    public List<Conjuntos> buscarPorNombre(@Param("nombre_Conjunto") String nombre_Conjunto);

    //NUEVO QUERY PARA BUSCAR LOS ULTIMOS MODIFICADOS
    @Query("SELECT c FROM Conjuntos c ORDER BY c.fecha_Modificacion DESC")
    List<Conjuntos> buscarUltimosModificados();



}
