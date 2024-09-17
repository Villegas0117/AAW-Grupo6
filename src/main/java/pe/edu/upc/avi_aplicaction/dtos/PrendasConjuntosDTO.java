package pe.edu.upc.avi_aplicaction.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.avi_aplicaction.entities.Conjuntos;
import pe.edu.upc.avi_aplicaction.entities.Prendas;

public class PrendasConjuntosDTO {
    private int idPrendasConjuntos;
    private Prendas id_Prenda;//FK
    private Conjuntos id_Conjunto;//FK

    public int getIdPrendasConjuntos() {
        return idPrendasConjuntos;
    }

    public void setIdPrendasConjuntos(int idPrendasConjuntos) {
        this.idPrendasConjuntos = idPrendasConjuntos;
    }

    public Prendas getId_Prenda() {
        return id_Prenda;
    }

    public void setId_Prenda(Prendas id_Prenda) {
        this.id_Prenda = id_Prenda;
    }

    public Conjuntos getId_Conjunto() {
        return id_Conjunto;
    }

    public void setId_Conjunto(Conjuntos id_Conjunto) {
        this.id_Conjunto = id_Conjunto;
    }
}
