package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoDia;

import java.time.LocalDateTime;
import java.util.List;

public interface IConjuntosDiaService {
    public List<ConjuntoDia> list();

    public void insert(ConjuntoDia conjuntoDia);
    public ConjuntoDia listId(Integer id);
    public void update(ConjuntoDia conjuntoDia);
    public void delete(Integer id);

    List<ConjuntoDia> buscarPorUsuario(int id_usuario);
    List<ConjuntoDia> buscarporIdConjunto(int id_conjunto);

    List<ConjuntoDia> buscarPorFechaCreacion(LocalDateTime inicio, LocalDateTime fin);
}
