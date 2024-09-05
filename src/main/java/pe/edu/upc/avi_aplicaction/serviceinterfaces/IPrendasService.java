package pe.edu.upc.avi_aplicaction.serviceinterfaces;

import pe.edu.upc.avi_aplicaction.entities.Prendas;
import java.util.List;

public interface IPrendasService {
    //Metodo para insertar nuevas prendas
    public void insertar_Prendas(Prendas prendas);

    //Metodo para listar lo que hay en la tabla prendas
    public List <Prendas> list();

    public void deletePrenda(int id);

    public Prendas listPrendaById(int id);

    public void updatePrenda(Prendas prendas);

    //public List<Prendas> busquedaPrendaFechas(LocalDate fecha_creacion);





}
