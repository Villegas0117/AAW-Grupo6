package pe.edu.upc.avi_aplicaction.serviceinterfaces;
import pe.edu.upc.avi_aplicaction.entities.roles;

import java.util.List;

public interface IRolesService {
    public List<roles> list();
    public void insert(roles role);
    public void update(roles role);
    public void delete(Long id_Rol);
    public roles listId(Long id_Rol);
    public List<roles> buscar(String rol);
}
