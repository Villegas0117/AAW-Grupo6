
package pe.edu.upc.avi_aplicaction.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.roles;

import java.util.List;

@Repository
public interface IRolesRepository extends JpaRepository <roles, Long> {
    @Query("SELECT r FROM roles r WHERE r.rol LIKE %:Tipo%")
    public List<roles> buscarRol(@Param("Tipo") String Tipo);
}
