package pe.edu.upc.avi_aplicaction.serviceinterfaces;
import org.apache.catalina.User;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

public interface IUsersService {
    public void insertUser(Users user);

    public List<Users> list();

    public void deleteUser(Long id);

    public Users listUserById(Long id);

    public void updateUser(Users user);

    public List<Users> searchUser(String email);




}
