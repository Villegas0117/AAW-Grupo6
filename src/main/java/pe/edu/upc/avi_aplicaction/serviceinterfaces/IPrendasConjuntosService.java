package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.entities.PrendasConjuntos;
import pe.edu.upc.avi_aplicaction.entities.Users;

import java.util.List;

public interface IPrendasConjuntosService {

    public void insert(PrendasConjuntos prendasConjuntos);

    public List<PrendasConjuntos> list();

    public void deletePrendasConjuntos(int id);

    public PrendasConjuntos listById(int id);

    public void updatePrendasConjuntos(PrendasConjuntos prendasConjuntos);

    //public List<PrendasConjuntos> searchUser(String email);

}
