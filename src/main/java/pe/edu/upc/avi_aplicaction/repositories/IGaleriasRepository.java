package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.avi_aplicaction.entities.Galerias;

import java.util.List;

import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
@Repository
public interface IGaleriasRepository extends JpaRepository<Galerias, Integer>{

    @Query(value = " SELECT u.username, g.nombre_galeria, MAX(g.fecha_creacion) AS ultima_galeria\n" +
            " FROM galerias g\n" +
            " INNER JOIN usuarios u ON g.id_Usuario = u.id\n" +
            " GROUP BY u.username, g.nombre_galeria\n" +
            " ORDER BY ultima_galeria DESC;",nativeQuery = true)
    public List<String[]> GaleriaMasReciente();
    //query para obtener el total de galerías por usuario

    @Query(value = " SELECT u.username, COUNT(*) AS total_galerias\n" +
            " FROM galerias g\n" +
            " INNER JOIN usuarios u ON g.id_Usuario = u.id\n" +
            " GROUP BY u.username\n" +
            " ORDER BY total_galerias DESC;",nativeQuery = true)
    public List<String[]> GaleriaPorUsuario();

}
