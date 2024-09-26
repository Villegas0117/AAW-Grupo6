package pe.edu.upc.avi_aplicaction.serviceinterfaces;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
import java.util.List;

public interface IGaleriasService {

    //Metodo para insertar nuevas galerias
    public void insertar(Galerias galerias);

    //Metodo para listar lo que hay en la tabla galerias
    public List<Galerias> list();

    public void deleteGaleria(int id);

    public Galerias listGaleriaById(int id);

    public void updateGalerias(Galerias Galerias);

    public List<String[]> GaleriaMasReciente();

    public List<String[]> GaleriaPorUsuario();
    
}
