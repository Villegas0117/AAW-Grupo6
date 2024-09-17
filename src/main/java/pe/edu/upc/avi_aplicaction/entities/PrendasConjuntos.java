package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "PrendasConjuntos")
public class PrendasConjuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrendasConjuntos;

    @ManyToOne
    @JoinColumn(name = "id_prenda")
    private Prendas id_Prenda;//FK

    @ManyToOne
    @JoinColumn(name = "id_Conjuntoo")
    private Conjuntos id_Conjunto;//FK

    public PrendasConjuntos() {
    }

    public PrendasConjuntos(int idPrendasConjuntos, Prendas id_Prenda, Conjuntos id_Conjunto) {
        this.idPrendasConjuntos = idPrendasConjuntos;
        this.id_Prenda = id_Prenda;
        this.id_Conjunto = id_Conjunto;
    }

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
