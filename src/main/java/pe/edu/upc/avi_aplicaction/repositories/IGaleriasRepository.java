package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
@Repository
public interface IGaleriasRepository extends JpaRepository<Galerias, Integer>{

}
