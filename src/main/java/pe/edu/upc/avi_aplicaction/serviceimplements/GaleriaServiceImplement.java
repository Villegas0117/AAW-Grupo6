package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Galeria;
import pe.edu.upc.avi_aplicaction.repositories.IGaleriaRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IGaleriaService;



@Service
public class GaleriaServiceImplement {
    @Autowired
    private IGaleriaRepository vR;

    @Override
    public List<Galeria> list(){return vR.findAll();}

    @Override
    public void inert(Galeria v) {vR.save(v);}

    @Override
    public Galeria listId(int id) {return vR.findById(id).orElse(new Galeria());}

    @Override
    public void update(Galeria v) {vR.save(v);}

    @Override
    public void delete(int id) {vR.deleteById(id);}

    @Override
    public List<Galeria> buscarnombre(String nombre) {return vR.buscargaleria(nombre);}
}
