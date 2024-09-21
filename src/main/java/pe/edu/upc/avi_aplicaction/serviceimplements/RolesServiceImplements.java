
package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.roles;
import pe.edu.upc.avi_aplicaction.repositories.IRolesRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRolesService;

import java.util.List;
@Service
public class RolesServiceImplements implements IRolesService {
    @Autowired
    private IRolesRepository rR;

    @Override
    public List<roles> list(){

        return rR.findAll();
    }

    @Override
    public void insert(roles rol) {
        rR.save(rol);

    }

    @Override
    public void update(roles rol) {
        rR.save(rol);
    }

    @Override
    public void delete(Long id_Rol) {
        rR.deleteById(id_Rol);
    }

    @Override
    public roles listId(Long id_Rol) {
        return rR.findById(id_Rol).orElse(new roles());
    }

    @Override
    public List<roles> buscar(String rol) {
        return rR.buscarRol(rol);
    }
}
