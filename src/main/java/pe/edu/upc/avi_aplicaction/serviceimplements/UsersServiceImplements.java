package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.entities.roles;
import pe.edu.upc.avi_aplicaction.repositories.IUsersRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplements implements IUsersService {
    @Autowired
    private IUsersRepository uR;


    @Override
    public void insertUser(Users user) {
        uR.save(user);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        uR.deleteById(id);
    }

    @Override
    public Users listUserById(Long id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public void updateUser(Users user) {
        uR.save(user);
    }

    @Override
    public List<Users> searchUser(String email) {
        return uR.buscarPorEmail(email);
    }



}