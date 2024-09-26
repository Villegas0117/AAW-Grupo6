package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoSemanal;
import pe.edu.upc.avi_aplicaction.entities.Conjuntos;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.repositories.IConjuntoDiaRepository;
import pe.edu.upc.avi_aplicaction.repositories.IConjuntosRepository;
import pe.edu.upc.avi_aplicaction.repositories.IUsersRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosDiaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConjuntoDiaServiceImplements implements IConjuntosDiaService {

    @Autowired
    private IConjuntoDiaRepository cDRepository;

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private IConjuntosRepository conjuntosRepository;

    @Override
    public List<ConjuntoSemanal> list() {
        return cDRepository.findAll();
    }

    @Override
    public void insert(ConjuntoSemanal conjuntoSemanal) {
        cDRepository.save(conjuntoSemanal);
    }

    @Override
    public ConjuntoSemanal listId(Integer id) {
        return cDRepository.findById(id).orElse(new ConjuntoSemanal());
    }

    @Override
    public void update(ConjuntoSemanal conjuntoSemanal) {
        cDRepository.save(conjuntoSemanal);
    }

    @Override
    public void delete(Integer id) {
        cDRepository.deleteById(id);
    }


    @Override
    public List<ConjuntoSemanal> buscarPorUsuario(int idUsuario) {
        return cDRepository.buscarPorUsuario(idUsuario);
    }

    @Override
    public List<ConjuntoSemanal> buscarporIdConjunto(int idUsuario) {
        return cDRepository.buscarporIdConjunto(idUsuario);
    }

    @Override
    public List<ConjuntoSemanal> buscarPorFechaCreacion(LocalDate inicio, LocalDate fin) {
        return cDRepository.findByFechaCreacionBetween(inicio, fin);
    }

    // Implementacion del query de valor: Obtener el registro mas reciente por usuario
    @Override
    public ConjuntoSemanal obtenerRegistroMasRecientePorUsuario(int id_usuario) {
        return cDRepository.obtenerRegistroMasRecientePorUsuario(id_usuario);
    }








}