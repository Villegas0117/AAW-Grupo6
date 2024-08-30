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

    @Override
    public List<roles> list(){
    }
}
