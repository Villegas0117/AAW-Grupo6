package pe.edu.upc.avi_aplicaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT d FROM Users d WHERE d.email LIKE %:email%")
    public List<Users> buscarPorEmail(@Param("email") String email);

}
