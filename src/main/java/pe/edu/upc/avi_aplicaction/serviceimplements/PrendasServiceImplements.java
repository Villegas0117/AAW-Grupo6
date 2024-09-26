package pe.edu.upc.avi_aplicaction.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.repositories.IPrendasRepository;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IPrendasService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrendasServiceImplements implements IPrendasService {
    @Autowired
    private IPrendasRepository pR;

    @Override
    public void insertar_Prendas(Prendas prendas) {
        pR.save(prendas);
    }

    @Override
    public List<Prendas> list() {
        return pR.findAll();
    }

    @Override
    public void deletePrenda(int id) {
        pR.deleteById(id);
    }

    @Override
    public Prendas listPrendaById(int id) {
        return pR.findById(id).orElse(new Prendas());
    }

    @Override
    public void updatePrenda(Prendas prendas) {
        pR.save(prendas);
    }

    @Override
    public List<Prendas> prendaPorTipo(String tipo_prenda) {
        return pR.buscarPorTipoPrenda(tipo_prenda);
    }

    @Override
    public List<Prendas> prendaPorFecha(LocalDate fecha) {
        return  pR.listarPorFecha(fecha);
    }
}
