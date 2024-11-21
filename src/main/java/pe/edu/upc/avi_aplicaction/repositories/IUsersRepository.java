package pe.edu.upc.avi_aplicaction.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {

    public Users findOneByUsername(String username);


    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);




    @Query("SELECT d FROM Users d WHERE d.email LIKE %:email%")
    public List<Users> buscarPorEmail(@Param("email") String email);


    @Query("SELECT d FROM Users d WHERE d.email =:email")
    public List<Users> buscarPorEmail2(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "CALL insertar_usuario_con_rol(:email, :password, :username)", nativeQuery = true)
    void insertarUsuarioConRol(@Param("email") String email,
                               @Param("password") String password,
                               @Param("username") String username);




}
