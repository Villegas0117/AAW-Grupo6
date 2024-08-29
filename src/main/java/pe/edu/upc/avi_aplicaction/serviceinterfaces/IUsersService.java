package pe.edu.upc.avi_aplicaction.serviceinterfaces;
import org.apache.catalina.User;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

public interface IUsersService {
    public void insertUser(Users user);

    public List<Users> list();

    public void deleteUser(int id);

    public Users listUserById(int id);

    public void updateUser(Users user);

    public List<Users> searchUser(String email);

}
