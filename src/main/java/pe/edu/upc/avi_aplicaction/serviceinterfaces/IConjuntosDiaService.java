package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.ConjuntoSemanal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IConjuntosDiaService {
    public List<ConjuntoSemanal> list();

    public void insert(ConjuntoSemanal conjuntoSemanal);
    public ConjuntoSemanal listId(Integer id);
    public void update(ConjuntoSemanal conjuntoSemanal);
    public void delete(Integer id);

    List<ConjuntoSemanal> buscarPorUsuario(int id_usuario);
    List<ConjuntoSemanal> buscarporIdConjunto(int id_conjunto);

    List<ConjuntoSemanal> buscarPorFechaCreacion(LocalDate inicio, LocalDate fin);

    // Query de valor: Obtener el registro mas reciente por usuario
    ConjuntoSemanal obtenerRegistroMasRecientePorUsuario(int id_usuario);
}
