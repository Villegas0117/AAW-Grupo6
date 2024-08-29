package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
@Repository
public interface IPrendasRepository extends JpaRepository<Prendas, Integer> {
}
